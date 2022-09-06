package com.ruoyi.extend.datasecurity.dbcolumn.aspect;

import com.ruoyi.extend.datasecurity.aesencrypt.utils.AesEncryptUtils;
import com.ruoyi.extend.datasecurity.dbcolumn.annotation.EncryptField;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * 加密处理
 *
 * @author Tellsea
 * @date 2022/9/3
 */
@Slf4j
@Aspect
@Component
public class EncryptAspect {

    @Pointcut("@annotation(com.ruoyi.extend.datasecurity.dbcolumn.annotation.NeedEncrypt)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        encrypt(joinPoint);
        return joinPoint.proceed();
    }

    public void encrypt(ProceedingJoinPoint joinPoint) {
        Object[] objects = null;
        try {
            objects = joinPoint.getArgs();
            if (objects.length != 0) {
                for (int i = 0; i < objects.length; i++) {
                    // 可自行扩展其他类型字段的判断
                    if (objects[i] instanceof String) {
                        objects[i] = encryptValue(objects[i]);
                    } else {
                        encryptObject(objects[i]);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 加密对象
     *
     * @param obj
     * @throws IllegalAccessException
     */
    private void encryptObject(Object obj) throws IllegalAccessException {
        if (Objects.isNull(obj)) {
            return;
        }
        Field[] fields = obj.getClass().getDeclaredFields();
        if (fields.length == 0) {
            fields = obj.getClass().getSuperclass().getDeclaredFields();
        }
        for (Field field : fields) {
            boolean containEncryptField = field.isAnnotationPresent(EncryptField.class);
            if (containEncryptField) {
                //获取访问权
                field.setAccessible(true);
                String value = null;
                try {
                    value = AesEncryptUtils.encrypt(String.valueOf(field.get(obj)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                field.set(obj, value);
            }
        }
    }

    /**
     * 加密单个值
     *
     * @param realValue
     * @return
     */
    public String encryptValue(Object realValue) {
        try {
            realValue = AesEncryptUtils.encrypt(String.valueOf(realValue));
        } catch (Exception e) {
            log.info("加密异常={}", e.getMessage());
        }
        return String.valueOf(realValue);
    }
}
