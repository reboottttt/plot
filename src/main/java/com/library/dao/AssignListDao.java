package com.library.dao;

import com.library.bean.AssignList;
import com.library.bean.Picture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: 穆肖肖
 * @Date: 2019/11/5
 * @Description: com.library.dao
 * @version: 1.0
 */

@Mapper
public interface AssignListDao {

    public int countAllList();

    //任务分页查询
    List<AssignList> AssignList();

    //标图人员任务查询
   List<AssignList> accountAssignList(String checkMember);

   //增加样本
    public  boolean insertAssign(AssignList assignList);

    public List<AssignList> getDownPath(String id);

    //增加图片

    public boolean insertPicture(Picture picture);
}
