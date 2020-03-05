package com.library.service;

import com.library.bean.Component;
import com.library.dao.ComponentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 周黎
 * @Date: 2019/11/4
 * @Description: com.library.service
 * @version: 1.0
 */
@Service
public class ComponentService {
    @Autowired
    ComponentDao partsDao;

    //查询部件信息
    public List<Component> searchPartsList() {
        return partsDao.searchPartsList();
    }

    //新增部件信息
    public boolean insertParts(Component part) {
        return partsDao.insertParts(part);
    }

    //更新部件
    public boolean updatePartByDtId(Component part) {
        return partsDao.updatePartByDtId(part);
    }

    //删除部件
    public boolean deletePart(Component part){
        return partsDao.deletePart(part);
    }

}
