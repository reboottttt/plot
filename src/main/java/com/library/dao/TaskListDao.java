package com.library.dao;

import com.library.bean.TaskList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: 穆肖肖
 * @Date: 2019/11/7
 * @Description: com.library.dao
 * @version: 1.0
 */

@Mapper
public interface TaskListDao {

    //获取数据总数
    public int countAllTask();

    //样本校验任务查询
    List<TaskList> allTaskList();

    //样本校验任务通过
    public boolean updateTaskStatusPass(TaskList taskStatusPass);

    //样本校验任务不通过
    public boolean updateTaskStatusReject(TaskList taskStatusReject);
}
