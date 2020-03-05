package com.library.bean;

import java.util.UUID;

/**
 * @Author: 周黎
 * @Date: 2019/11/4
 * @Description: com.library.bean
 * 部件
 * @version: 1.0
 */
public class Component {
    private String dtId;//
    private String typeCode;//类别编码
    private String typeName;//类别名称
    private String partsCode;//部件编码
    private String partsName;//部件名称

    public void setDtId(String dtId) {
        this.dtId = dtId;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setPartsCode(String partsCode) {
        this.partsCode = partsCode;
    }

    public void setPartsName(String partsName) {
        this.partsName = partsName;
    }

    public String getDtId() {

        return dtId;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getPartsCode() {
        return partsCode;
    }

    public String getPartsName() {
        return partsName;
    }
}
