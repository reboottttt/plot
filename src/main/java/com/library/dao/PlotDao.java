package com.library.dao;

import com.library.bean.Plot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 穆肖肖
 * @Date: 2019/11/7
 * @Description: com.library.dao
 * @version: 1.0
 */

@Mapper
public interface PlotDao {


    public int countAllList();
    //标图任务查询
    List<Plot> plotList();

    //图片标注 - 图片分页查询
    List<Plot> picList(@Param("uapId")String uapId);

    //图片标注 - 提交审核
    public boolean updateassignStatus(@Param("uapId")String uapId);

    //更新任务的已标注图片数
    public boolean updatePlotNum(@Param("uapId")String uapId, @Param("plotNum")int plotNum);

    //生成审核ID
//    public boolean createUrpId();

    //删除任务
    public boolean deleteUapId(Plot plot);
}
