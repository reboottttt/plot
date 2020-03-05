package com.library.service;

import com.library.bean.Plot;
import com.library.dao.PlotDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 穆肖肖
 * @Date: 2019/11/7
 * @Description: com.library.service
 * @version: 1.0
 */

@Service
public class PlotService {

    @Autowired
    PlotDao plotDao;
    public int countAllList() { return plotDao.countAllList(); }

    //标图任务查询
    public List<Plot> plotList() { return plotDao.plotList(); }

    //图片标注 - 图片分页查询
    public List<Plot> picList(String uapId) { return plotDao.picList(uapId); }

    //图片标注 - 提交审核
    public boolean updateassignStatus(String uapId) {return plotDao.updateassignStatus(uapId); }

    //更新任务的已标注图片数
    public boolean updatePlotNum(String uapId, int plotNum) {return plotDao.updatePlotNum(uapId, plotNum); }

    //删除任务
    public boolean deleteUapId(Plot plot) {return plotDao.deleteUapId(plot);}
}

