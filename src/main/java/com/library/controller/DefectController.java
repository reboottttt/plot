package com.library.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.library.bean.Component;
import com.library.bean.Defect;
import com.library.service.DefectService;
import com.library.utils.Result;
import com.library.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

/**
 * @Author: 周黎
 * @Date: 2019/11/4
 * @Description: com.library.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/api/v1.0/pic")
public class DefectController {
    @Autowired
    DefectService defectService;
    //

    /**
     * 新增缺陷信息
     * <p>
     * {{
     * {"dtId":"001","did":"999","name":"88888","defectCode":"6666666","code":"0"}
     * }
     */
    @RequestMapping(value = "/defectManagement", method = RequestMethod.POST)
    public Result<Defect> createDefect(@RequestBody Defect defect) {
        UUID uuid = UUID.randomUUID();
        defect.setdId(String.valueOf(uuid));
        //通过dtid查询部件表的typecode和partscode
        List<Component> list = defectService.searchCode(defect.getDtId());
            Component component = list.get(0);
            String typecode = component.getTypeCode();
            String partcode = component.getPartsCode();
            defect.setCode(typecode+partcode+defect.getDefectCode().toString());
        return ResultUtil.success(defectService.insertDefects(defect));
    }


    //查询
//    @RequestMapping(value = "/defectManagement", method = RequestMethod.GET, params = {"dtId"})
////, "currentPage", "pageSize"}
//    public Result<PageInfo> searchDefectList(HttpServletRequest request) {
//        String dtid = request.getParameter("dtId");
//        return ResultUtil.success(defectService.searchDefectList(dtid));
//    }
    @RequestMapping(value="/defectManagement",method= RequestMethod.GET)
    public Result<PageInfo> searchDefectList(@RequestParam (value = "dtId", required = false) String dtId) {
        return ResultUtil.success(defectService.searchDefectList(dtId));
    }

    //更新缺陷信息
    @RequestMapping(value = "/defectManagement", method = RequestMethod.PUT)
    /*
     * {"did":"111","dtId":"101","name":"fubijing3","defectCode":"111","code":"1"}
     * */
    public Result<Defect> updateDefect(@RequestBody Defect defect) {
        //通过id查询dtid
        List<Defect> list = defectService.serachDtId(defect.getdId());
        defect.setDtId(list.get(0).getDtId());
        //通过dtid查询部件表的typecode和partscode
        List<Component> list2 = defectService.searchCode(list.get(0).getDtId());
        Component component = list2.get(0);
        String typecode = component.getTypeCode();
        String partcode = component.getPartsCode();
        defect.setCode(typecode+partcode+defect.getDefectCode().toString());
        return ResultUtil.success(defectService.updateDefect(defect));
    }
    //根据did删除缺陷信息{dId:'5557e728-b600-4ff5-a604-b7ff06d8cc41'}
    //{"dId":"a2a846f6-4bf6-4ca8-9296-32508f2f8255"}
    @RequestMapping(value = "/defectManagement", method = RequestMethod.DELETE)
    public  Result deleteDefectByDid(@RequestBody Defect defect){
        System.out.println("--------------开始删除缺陷------"+defect.getdId());
        return  ResultUtil.success(defectService.deleteDefectByDid(defect));
    }

}
