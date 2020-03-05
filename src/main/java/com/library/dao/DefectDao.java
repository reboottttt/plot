package com.library.dao;

import com.library.bean.Component;
import com.library.bean.Defect;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: 周黎
 * @Date: 2019/11/4
 * @Description: com.library.dao
 * @version: 1.0
 */
@Mapper

public interface DefectDao {
    //增加部件
    public boolean insertDefects(Defect defect);

    //查询缺陷
    List<Defect> searchDefectList(String dtId);

    public boolean updateDefect(Defect defect);

    List<Defect> serachDtId(String id);

    List<Component> searchCode(String dtId);

    //删除缺陷
    boolean deleteDefectByDid(Defect defect);
}
