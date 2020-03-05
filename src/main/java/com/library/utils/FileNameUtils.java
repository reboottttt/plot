package com.library.utils;

/**
 * @Author: 周黎
 * @Date: 2019/11/5
 * @Description: com.library.utils
 * @version: 1.0
 */
public class FileNameUtils {
    /**
     * 获取文件后缀
     * @param fileName
     * @return
     */
    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }
    /**
     * 生成新的文件名
     * @param fileOriginName 源文件名
     * @return
     */
    public static String getFileName(String fileOriginName){
        return UUIDUtils.getUUID() + FileNameUtils.getSuffix(fileOriginName);
    }
}
