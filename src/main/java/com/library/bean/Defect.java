package com.library.bean;

/**
 * @Author: 周黎
 * @Date: 2019/11/4
 * @Description: com.library.bean
 * @version: 1.0
 */
public class Defect {
    private  int id;
    private  String dtId;
    private  String dId;
    private  String name;
    private  String defectCode;
    private  String code;
    private  String typeCode;



    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public void setId(int id) {
        this.id = id;
    }




    public void setName(String name) {
        this.name = name;
    }



    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {

        return id;
    }

    public String getDtId() {
        return dtId;
    }

    public void setDtId(String dtId) {
        this.dtId = dtId;
    }

    public String getdId() {
        return dId;
    }

    public String getName() {
        return name;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public void setDefectCode(String defectCode) {
        this.defectCode = defectCode;
    }

    public String getDefectCode() {

        return defectCode;
    }

    public String getCode() {
        return code;
    }
}
