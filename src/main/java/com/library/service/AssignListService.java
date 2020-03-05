package com.library.service;

import com.library.bean.AssignList;
import com.library.bean.Picture;
import com.library.dao.AssignListDao;
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
public class AssignListService {
    @Autowired
    AssignListDao assignListDao;

    public int countAllList() { return assignListDao.countAllList(); }

    //任务分页查询
    public List<AssignList> AssignList() {
        return assignListDao.AssignList();
    }

    //标图人员任务查询
    public List<AssignList> accountAssignList(String checkMember) { return assignListDao.accountAssignList(checkMember);}

    //增加样本
    public boolean insertAssign(AssignList assignList){
        return  assignListDao.insertAssign(assignList);
    }
    //
    public List<AssignList> getDownPath(String id){
        return assignListDao.getDownPath(id);
    }

    public boolean insertPicture(Picture picture){
        return  assignListDao.insertPicture(picture);
    };
}
