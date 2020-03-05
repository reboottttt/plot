package com.library.service;

import com.library.bean.Component;
import com.library.bean.Defect;
import com.library.dao.DefectDao;
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

public class DefectService {
    @Autowired
    DefectDao defectdao;
    //新增缺陷信息
    public boolean insertDefects(Defect defect){
//        return partsDao.insertParts(part);
        return  defectdao.insertDefects(defect);
    }
    //查询缺陷
    public List<Defect> searchDefectList(String dtId){
        return  defectdao.searchDefectList(dtId);
    }

    //更新部件
    public boolean updateDefect(Defect defect){
        return defectdao.updateDefect(defect);
    }

    //通过id查询dtid

    public List<Defect> serachDtId(String id){
     return defectdao.serachDtId(id);
    }

    //通过dtid查询部件表的typecode和partscode
    public List<Component> searchCode(String dtId){
        return  defectdao.searchCode(dtId);
    };
    //删除缺陷
    public boolean deleteDefectByDid(Defect defect){
         return  defectdao.deleteDefectByDid(defect);
    }
}
