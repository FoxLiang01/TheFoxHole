package com.ruoyi.extend.configsecurity;

import com.baomidou.mybatisplus.core.toolkit.AES;

/**
 * MybatisPlus 数据安全保护
 *
 * @author Tellsea
 * @date 2022/9/3
 */
public class DataSecurityTest {

    public static void main(String[] args) {
        // 生成 16 位随机 AES 密钥
        String randomKey = AES.generateRandomKey();
        // 随机密钥加密
        System.out.println("随机密钥：" + randomKey);
        String url = "jdbc:mysql://127.0.0.1:3306/ruoyi-vue-service?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";
        System.out.println("url: mpw:" + AES.encrypt(url, randomKey));
        System.out.println("username: mpw:" + AES.encrypt(username, randomKey));
        System.out.println("password: mpw:" + AES.encrypt(password, randomKey));
    }
}
