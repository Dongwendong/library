package edu.nf.library.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author dwd
 * @date 2019/11/20
 */
public class MD5Util {
    public static String encode(String str) {
        // 定义一个字节数组
        byte[] secretBytes = null;
        try {
            // 创建MD5加密算法实例
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 加密字符串
            md.update(str.getBytes());

            // 获取加密后的数据
            secretBytes = md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }

        // 将加密后的数据转换为16进制数字
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字

        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code.toUpperCase();
    }

    public static boolean equals(String newPasswd, String oldPasswd) {
        return encode(newPasswd).equalsIgnoreCase(oldPasswd) ? true : false;
    }
}