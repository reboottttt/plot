package com.library.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.library.bean.Plot;
import com.library.bean.PlotSize;
import com.library.service.PlotService;
import com.library.service.PlotSizeService;
import com.library.utils.Result;
import com.library.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;


/**
 * @Author: 穆肖肖
 * @Date: 2019/11/11
 * @Description: com.library.controller
 * @version: 1.0
 */

@RestController
@RequestMapping("/api/v1.0/pic")
public class PlotSizeController {

    @Autowired
    PlotSizeService plotSizeService;

    //添加图片标注
    @RequestMapping(value = "/submitLabel" , method = RequestMethod.POST)
    public Result<PlotSize> insertPlotSize(@RequestBody String plotSize){

        System.out.println("开始新增图片标注.........");
        //将标注状态设置为已标注update

        JSONObject plotsize = (JSONObject) JSONObject.parse(plotSize);

        int uardId = plotsize.getInteger("uardId");
        String size = plotsize.getJSONObject("size").toJSONString();
        String plotDataDo = plotsize.getJSONArray("plotData").toJSONString();
        String filename = plotsize.getString("filename");

        return ResultUtil.success(plotSizeService.insertPlotSize(size, plotDataDo, filename, uardId));
    }
    //http://localhost:8080/api/v1.0/pic/submitLabel
}
