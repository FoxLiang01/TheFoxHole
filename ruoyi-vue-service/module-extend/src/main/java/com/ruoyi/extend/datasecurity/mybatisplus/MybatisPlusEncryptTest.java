package com.ruoyi.extend.datasecurity.mybatisplus;

import com.baomidou.mybatisplus.core.toolkit.AES;

/**
 * MybatisPlus 数据安全保护，配置文件加密
 *
 * @author Tellsea
 * @date 2022/9/3
 */
public class MybatisPlusEncryptTest {

    public static void main(String[] args) {
        // 生成 16 位随机 AES 密钥
        String randomKey = AES.generateRandomKey();
        randomKey = "b8123298c638fb4c";
        // 随机密钥加密
        System.out.println("随机密钥：" + randomKey);
        String url = "jdbc:mysql://127.0.0.1:3306/ruoyi-vue-service?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";
        System.out.println("数据库账号密码：");
        System.out.println("url: mpw:" + AES.encrypt(url, randomKey));
        System.out.println("username: mpw:" + AES.encrypt(username, randomKey));
        System.out.println("password: mpw:" + AES.encrypt(password, randomKey));
        System.out.println("Druid 账号密码：");
        System.out.println("login-username: mpw:" + AES.encrypt("admin", randomKey));
        System.out.println("login-password: mpw:" + AES.encrypt("rootadmin@123", randomKey));
        System.out.println("微信配置：");
        System.out.println("appId: mpw:" + AES.encrypt("wxfed44936431200f0", randomKey));
        System.out.println("secret: mpw:" + AES.encrypt("8486ea1cf41d2fb20f81fa810b5b26e6", randomKey));
    }
}
