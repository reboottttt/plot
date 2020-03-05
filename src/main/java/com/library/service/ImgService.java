package com.library.service;

import com.library.bean.ImageUpload;
import com.library.dao.ImageUploadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 周黎
 * @Date: 2019/11/12
 * @Description: com.library.service.impl
 * @version: 1.0
 */
@Service
public class ImgService {
    @Autowired

    ImageUploadDao imageUploadDao;
    public boolean insertImg(ImageUpload zip){
        return imageUploadDao.insertImgZip(zip);
    }

}
