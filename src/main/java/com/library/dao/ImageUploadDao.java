package com.library.dao;

import com.library.bean.ImageUpload;

/**
 * @Author: 周黎
 * @Date: 2019/11/6
 * @Description: com.library.dao
 * @version: 1.0
 */
public interface ImageUploadDao {
    int insertImgPath(String imgPath);
    boolean insertImgZip(ImageUpload zipLoad);
}
