package com.library.service;

import com.library.bean.Component;
import com.library.bean.ImageUpload;
import org.springframework.stereotype.Service;

/**
 * @Author: 周黎
 * @Date: 2019/11/6
 * @Description: com.library.service
 * @version: 1.0
 */
public interface IImgUploadService {
    String imgUpload(String imgPath);
}
