package com.library.controller;

import com.library.bean.TaskList;
import com.library.service.TaskListService;
import com.library.utils.Result;
import com.library.utils.ResultUtil;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 穆肖肖
 * @Date: 2019/11/5
 * @Description: com.library.controller
 * 分派图片
 * @version: 1.0
 */

@RestController
@RequestMapping("/api/v1.0/pic")
public class TaskListController {

    @Autowired
    TaskListService taskListService;

    //样本校验查询
    @RequestMapping(value = "/reviewSampleList",method = RequestMethod.GET)
    public Result<TaskList> allTaskList(){
        System.out.println("开始查询.........");
        int filterCount = taskListService.countAllTask();
        System.out.println(ResultUtil.pagesuccess(taskListService.allTaskList(), filterCount));
        return ResultUtil.pagesuccess(taskListService.allTaskList(), filterCount);
//        return ResultUtil.success(taskListService.allTaskList());
    }
    //http://localhost:8080/api/v1.0/pic/reviewSampleList?currentPage=2&pageSize=2

    //样本校验任务通过
    @RequestMapping(value = "/passReview", method = RequestMethod.PUT)
    public Result<TaskList> updateTaskStatusPass(@RequestBody TaskList taskStatusPass){
        return ResultUtil.success(taskListService.updateTaskStatusPass(taskStatusPass));
    }
    //http://localhost:8080/api/v1.0/pic/passReview
//    {
//        "urpId":"1",
//            "reviewStatus":"1",
//            "accuracy":"96"
//    }


    //样本校验任务不通过
    @RequestMapping(value = "/rejectReview", method = RequestMethod.PUT)
    public Result<TaskList> updateTaskStatusReject(@RequestBody TaskList taskStatusReject){
        return ResultUtil.success(taskListService.updateTaskStatusReject(taskStatusReject));
    }
    //http://localhost:8080/api/v1.0/pic/rejectReview
    //    {
//        "urpId":"1",
//            "reviewStatus":"0",
//            "rejectReason":"11111111111"
//    }

}
