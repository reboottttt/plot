package com.library.dao;

import com.library.bean.Component;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: 周黎
 * @Date: 2019/11/4
 * @Description: com.library.dao
 * @version: 1.0
 */
@Mapper
public interface ComponentDao {
    //查询部件信息
    List<Component> searchPartsList();

    //增加部件
    public boolean insertParts(Component part);
    //更新部件
    public boolean updatePartByDtId(Component part);

    boolean deletePart(Component part);

}
