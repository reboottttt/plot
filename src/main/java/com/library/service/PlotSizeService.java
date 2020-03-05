package com.library.service;

import com.library.bean.PlotSize;
import com.library.dao.PlotSizeDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 穆肖肖
 * @Date: 2019/11/7
 * @Description: com.library.service
 * @version: 1.0
 */

@Service
public class PlotSizeService {

    @Autowired
    PlotSizeDao plotSizeDao;

    //更新任务的已标注图片数
    public int countPlotNum(String uapId) {
        return plotSizeDao.countPlotNum(uapId);
    }

    //添加图片标注
    public boolean insertPlotSize(String size, String plotDataDo, String filename, int uardId){

        //存在uardId即是更新图片标注信息
        if (plotSizeDao.judgePlotSize(uardId) > 0 ){
            return plotSizeDao.updatePlotSize(size, plotDataDo, filename,uardId);
        }

        return plotSizeDao.insertPlotSize(size, plotDataDo, filename,uardId);
    }

    public boolean deletePicture(PlotSize plotSize){
        return plotSizeDao.deletePicture(plotSize);
    }
}
