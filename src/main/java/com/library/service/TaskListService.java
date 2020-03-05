package com.library.service;

import com.library.bean.TaskList;
import com.library.dao.TaskListDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 穆肖肖
 * @Date: 2019/11/5
 * @Description: com.library.service
 * @version: 1.0
 */

@Service
public class TaskListService {

    @Autowired
    TaskListDao taskListDao;

    public int countAllTask() {return taskListDao.countAllTask();}

    //样本校验任务查询
    public List<TaskList> allTaskList() { return taskListDao.allTaskList(); }

    //样本校验任务通过
    public boolean updateTaskStatusPass(TaskList taskStatusPass) {return taskListDao.updateTaskStatusPass(taskStatusPass);}

    //样本校验任务不通过
    public boolean updateTaskStatusReject(TaskList taskStatusReject) {return taskListDao.updateTaskStatusReject(taskStatusReject);}

}
