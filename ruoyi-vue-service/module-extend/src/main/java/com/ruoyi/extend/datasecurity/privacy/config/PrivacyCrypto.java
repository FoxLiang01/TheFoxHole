package com.ruoyi.extend.datasecurity.privacy.config;

import cn.zhz.privacy.crypto.ICrypto;
import cn.zhz.privacy.enums.Algorithm;
import com.ruoyi.extend.datasecurity.aesencrypt.utils.AesEncryptUtils;

/**
 * privacy 自定义加密规则
 *
 * @author Tellsea
 * @date 2022/9/6
 */
public class PrivacyCrypto implements ICrypto {

    @Override
    public String encrypt(Algorithm algorithm, String s, String s1) throws Exception {
        return AesEncryptUtils.encrypt(s);
    }

    @Override
    public String decrypt(Algorithm algorithm, String s, String s1) throws Exception {
        return AesEncryptUtils.decrypt(s);
    }
}
