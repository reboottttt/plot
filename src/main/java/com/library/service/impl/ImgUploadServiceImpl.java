package com.library.service.impl;

import com.library.bean.ImageUpload;
import com.library.dao.ImageUploadDao;
import com.library.service.IImgUploadService;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 周黎
 * @Date: 2019/11/6
 * @Description: com.library.service.impl
 * @version: 1.0
 */
@Service("iImgUploadService")
@MapperScan("com.library.dao")
public class ImgUploadServiceImpl implements IImgUploadService {
    @Autowired
    ImageUploadDao imageUploadDao;

    private static Logger logger = LoggerFactory.getLogger("ImgUploadServiceImpl.class");

    /**
     * 存储上传图片的路径
     *
     * @param
     * @return
     */
    @Override
    public String imgUpload(String imgPath) {
        ImageUpload upload = new ImageUpload();
        upload.setImgpath(imgPath);
        // 一定要加非空判断，否则会报空指针异常
        if (upload.getImgpath() == null) {
            return "图片地址为空";
        }
        logger.info("向数据库中存储的路径为：" + upload.getImgpath());
        logger.info("传递过来的imgPath参数为：" + imgPath);
        logger.info(upload.toString());
        int rowCount = imageUploadDao.insertImgPath(imgPath);
        logger.error(rowCount + "");
        if (rowCount > 0) {
            return "图片地址存储成功";
        }
        return "图片地址存储失败";
    }

}
