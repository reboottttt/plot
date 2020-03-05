package com.library.utils;

import java.util.UUID;

/**
 * @Author: 周黎
 * @Date: 2019/11/5
 * @Description: com.library.utils
 * @version: 1.0
 */
public class UUIDUtils {
    /**
     * 生成文件名
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
