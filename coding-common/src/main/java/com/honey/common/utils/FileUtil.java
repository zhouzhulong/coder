package com.honey.common.utils;

import org.springframework.util.Base64Utils;
import org.springframework.util.DigestUtils;

import java.io.FileInputStream;

/**
 * @author zlzhou
 */
public class FileUtil {

    public static void main(String[] args) throws Exception {
        System.out.println(md5EncryptWithBase64("/Users/zhouzhulong/Documents/spring-tiny.md"));
    }

    public static String md5EncryptWithBase64(String videoPath) throws Exception {
        byte[] bytes = DigestUtils.md5Digest(new FileInputStream(videoPath));
        return Base64Utils.encodeToString(bytes);
    }
}
