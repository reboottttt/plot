package com.library.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.library.bean.Component;
import com.library.bean.Defect;
import com.library.service.ComponentService;
import com.library.service.DefectService;
import com.library.utils.Result;
import com.library.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @Author: 周黎
 * @Date: 2019/11/4
 * @Description: com.library.controller
 * @version: 1.0
 */
@RestController
//@RequestMapping("/part")
@RequestMapping("/api/v1.0/pic")
public class ComponentController {
    @Autowired
    ComponentService partsService;
    @Autowired
    DefectService defectService;

    //查询部件信息
    @RequestMapping(value = "/partsManagement", method = RequestMethod.GET)
//, params = {"currentPage", "pageSize"}
    public Result<PageInfo> searchPartList(HttpServletRequest request){
        //return partsService.searchPartsList();
        System.out.println("开始查询.........");
        return ResultUtil.success(partsService.searchPartsList());
    }
    //http://localhost:8080//api/v1.0/pic/partsManagement?currentPage=1&&pageSize=10

    //新增部件
    /*
    * {"dtId": 11, "typeCode": "04", "typeName": "杆塔", "partsCode": "01", "partsName": "杆塔" }
    * */
    @RequestMapping(value = "/partsManagement", method = RequestMethod.POST)
    public Result<Component> createPart(@RequestBody Component part) {
        System.out.println("开始新增.........");
        UUID uuid = UUID.randomUUID();
        part.setDtId(String.valueOf(uuid));
        return ResultUtil.success(partsService.insertParts(part));
    }
    /*
     * 更新部件
     * {"typeName":"ganzi","typeCode":"666","partsName":"ganzi","partsCode":"222"}
     * */
    @RequestMapping(value = "/partsManagement", method = RequestMethod.PUT)
    public Result<Component> updatePart(@RequestBody Component part, BindingResult bindingResult) {
        System.out.println("开始更新.........");
        return ResultUtil.success(partsService.updatePartByDtId(part));
    }

    /*
    * 删除部件
    * {}
    * */
    @RequestMapping(value = "/partsManagement", method = RequestMethod.DELETE)
    public  Result deleteDefectByDid(@RequestBody Component component){
        System.out.println("删除部件+++++以及缺陷++++++++==");
        //得到DTID
        String dtid = component.getDtId();
        //通过Dtid查询did
        List list = defectService.searchDefectList(dtid);
        for (int i = 0;i<list.size();i++){
            Defect defect = new Defect();
            HashMap mapDefect = (HashMap) list.get(i);
            String did = (String) mapDefect.get("dId");
            defect.setdId(did);
            //删除缺陷
            defectService.deleteDefectByDid(defect);
        }
        //删除部件
        return ResultUtil.success(partsService.deletePart(component));
    }
}
