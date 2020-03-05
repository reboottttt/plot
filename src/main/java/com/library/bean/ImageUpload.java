package com.library.bean;

/**
 * @Author: 周黎
 * @Date: 2019/11/6
 * @Description: com.library.bean
 * @version: 1.0
 */
public class ImageUpload {
    private String imgpath;//图片路径
    private String sampleName;//样本库名称
    private String checkMember;//标图人员
    private String pictureNumber;//图片数量
    private String acceptedList;//url

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public void setCheckMember(String checkMember) {
        this.checkMember = checkMember;
    }

    public void setPictureNumber(String pictureNumber) {
        this.pictureNumber = pictureNumber;
    }

    public void setAcceptedList(String acceptedList) {
        this.acceptedList = acceptedList;
    }

    public String getSampleName() {

        return sampleName;
    }

    public String getCheckMember() {
        return checkMember;
    }

    public String getPictureNumber() {
        return pictureNumber;
    }

    public String getAcceptedList() {
        return acceptedList;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath == null ? null : imgpath.trim();
    }
}
