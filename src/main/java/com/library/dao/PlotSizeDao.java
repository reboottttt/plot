package com.library.dao;

import com.library.bean.PlotSize;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 穆肖肖
 * @Date: 2019/11/11
 * @Description: com.library.dao
 * @version: 1.0
 */

@Mapper
public interface PlotSizeDao {

    //判断是否更新
    int judgePlotSize(@Param("uardId")int uardId);

    //获取已标注图片数目
    int countPlotNum(@Param("uapId")String uapId);

    //添加图片标注
    boolean insertPlotSize(@Param("size") String size, @Param("plotDataDo")String plotDataDo, @Param("filename")String filename, @Param("uardId")int uardId);

    //删除图片标注
    boolean updatePlotSize(@Param("size") String size, @Param("plotDataDo")String plotDataDo, @Param("filename")String filename, @Param("uardId")int uardId);

    //删除图片
    boolean deletePicture(PlotSize plotSize);

}
