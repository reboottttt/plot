package com.library.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.library.bean.Plot;
import com.library.service.PlotService;
import com.library.service.PlotSizeService;
import com.library.utils.Result;
import com.library.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: 穆肖肖
 * @Date: 2019/11/7
 * @Description: com.library.controller
 * 分派图片
 * @version: 1.0
 */

@RestController
@RequestMapping("/api/v1.0/pic")
public class PlotController {

    @Autowired
    PlotService plotService;

    @Autowired
    PlotSizeService plotSizeService;

    @Autowired
    private RestTemplate restTemplate;



    //标图任务查询
    @RequestMapping(value = "/getTaskList",method = RequestMethod.GET)
    public Result<Plot> plotList(HttpServletRequest request){

//        String token = request.getHeader("X-ACCESS-TOKEN");
//        Map<String,Object> user = restTemplate.getForObject("http://10.20.74.189:8081/api/v1.0/user/userinfo?token="+token,Map.class);
//        String checkMember = user.get("id").toString();
//
//        checkMember




        int filterCount = plotService.countAllList();

        return ResultUtil.pagesuccess(plotService.plotList(), filterCount);
    }
    //http://localhost:8080/api/v1.0/pic/getTaskList?id=1&currentPage=2&pageSize=10

    @RequestMapping(value = "/getPictureList",method = RequestMethod.GET )
    public Result<Plot> picList(HttpServletRequest request){
        String uapId = request.getParameter("uapId");

        //获取已标注图片数
        int plotNum = plotSizeService.countPlotNum(uapId);
        plotService.updatePlotNum(uapId, plotNum);

        return ResultUtil.success(plotService.picList(uapId));
    }

    //提交审核
    @RequestMapping(value = "/submitReview", method = RequestMethod.POST)
    public Result<Plot> updateassignStatus(@RequestBody Plot plot) {
        String uapId = plot.getUapId();

        return ResultUtil.success(plotService.updateassignStatus(uapId));
    }
    //http://localhost:8080/api/v1.0/pic/submitReview
}