package com.ruoyi.extend.datasecurity.dbcolumn.aspect;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.extend.datasecurity.aesencrypt.utils.AesEncryptUtils;
import com.ruoyi.extend.datasecurity.dbcolumn.annotation.EncryptField;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 解密处理
 *
 * @author Tellsea
 * @date 2022/9/3
 */
@Slf4j
@Aspect
@Component
public class DecryptAspect {

    @Pointcut("@annotation(com.ruoyi.extend.datasecurity.dbcolumn.annotation.NeedDecrypt)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = decrypt(joinPoint);
        return result;
    }

    public Object decrypt(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            Object obj = joinPoint.proceed();
            if (obj != null) {
                // 可自行扩展其他类型字段的判断
                if (obj instanceof String) {
                    decryptValue(obj);
                } else {
                    result = decryptData(obj);
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }

    private Object decryptData(Object obj) throws IllegalAccessException {
        if (Objects.isNull(obj)) {
            return null;
        }
        if (obj instanceof TableDataInfo) {
            TableDataInfo tableDataInfo = (TableDataInfo) obj;
            decryptList(tableDataInfo.getRows());
        } else if (obj instanceof AjaxResult) {
            AjaxResult ajaxResult = (AjaxResult) obj;
            Object data = ajaxResult.get("data");
            if (data instanceof ArrayList) {
                decryptList(data);
            }
        } else if (obj instanceof ArrayList) {
            decryptList(obj);
        } else {
            decryptObj(obj);
        }
        return obj;
    }

    /**
     * 针对单个实体类进行 解密
     *
     * @param obj
     * @throws IllegalAccessException
     */
    private void decryptObj(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        if (fields.length == 0) {
            fields = obj.getClass().getSuperclass().getDeclaredFields();
        }
        for (Field field : fields) {
            boolean hasSecureField = field.isAnnotationPresent(EncryptField.class);
            if (hasSecureField) {
                field.setAccessible(true);
                String realValue = (String) field.get(obj);
                String value = null;
                try {
                    value = AesEncryptUtils.decrypt(realValue);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                field.set(obj, value);
            }
        }
    }

    /**
     * 针对list<实体来> 进行反射、解密
     *
     * @param obj
     * @throws IllegalAccessException
     */
    private void decryptList(Object obj) throws IllegalAccessException {
        List<Object> result = new ArrayList<>();
        if (obj instanceof ArrayList) {
            for (Object o : (List<?>) obj) {
                result.add(o);
            }
        }
        for (Object object : result) {
            decryptObj(object);
        }
    }

    /**
     * 解密单个值
     *
     * @param realValue
     * @return
     */
    public String decryptValue(Object realValue) {
        try {
            realValue = AesEncryptUtils.encrypt(String.valueOf(realValue));
        } catch (Exception e) {
            log.info("解密异常={}", e.getMessage());
        }
        return String.valueOf(realValue);
    }
}
