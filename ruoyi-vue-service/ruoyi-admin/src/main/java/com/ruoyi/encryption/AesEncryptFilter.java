package com.ruoyi.encryption;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.HttpMethod;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 解密过滤器
 *
 * @author Tellsea
 * @date 2021/09/27
 */
@Slf4j
@Component
public class AesEncryptFilter extends OncePerRequestFilter {

    private static final String CONTENT_TYPE_CHARSET = "application/json;charset=UTF-8";

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        List<String> whiteUrl = Arrays.asList(
                "/ruoyi-vue-service/common",
                "/ruoyi-vue-service/au/weiXin/callBack"
        );
        if (whiteUrl.contains(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }
        ObjectMapper om = new ObjectMapper();
        response.setContentType(CONTENT_TYPE_CHARSET);
        if (HttpMethod.POST.name().equals(request.getMethod())) {
            PostParamsRequestWrapper requestWrapper = new PostParamsRequestWrapper(request);
            filterChain.doFilter(requestWrapper, response);
            return;
        }
        String aesData = request.getParameter("aesData");
        if (StringUtils.isEmpty(aesData)) {
            om.writeValue(response.getWriter(), AjaxResult.error("参数解析错误，不能为空"));
            return;
        }
        try {
            String decode = URLDecoder.decode(aesData, "UTF-8");
            String decrypt = AesEncryptUtils.decrypt(decode);
            JSONObject jSONObject = JSON.parseObject(decrypt);
            HashMap params = new HashMap(request.getParameterMap());
            params.remove("aesData");
            params.remove("noData");
            for (String str : jSONObject.keySet()) {
                if (str.equals("params")) {
                    params.remove(str);
                } else {
                    params.put(str, jSONObject.get(str));
                }
            }
            GetParamsRequestWrapper requestWrapper = new GetParamsRequestWrapper(request, params);
            filterChain.doFilter(requestWrapper, response);
        } catch (Exception e) {
            log.error("转换错误" + getExceptionInfo(e));
            om.writeValue(response.getWriter(), AjaxResult.error("参数异常"));
            return;
        }
    }

    public static String getExceptionInfo(Exception e) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        e.printStackTrace(new PrintStream(baos));
        return baos.toString();
    }
}
