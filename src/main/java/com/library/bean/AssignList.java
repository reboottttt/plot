package com.library.bean;

/**
 * @Author: 穆肖肖
 * @Date: 2019/11/5
 * @Description: com.library.bean
 * 任务分页
 * @version: 1.0
 */
public class AssignList {

    private int id;              //样本id
    private String account;        //当前用户
    private String checkMember;    //标图人员
    private String sampleName;     //图片样本名称
    private String pictureNumber;  //图片数量
    private String startTime;      //创建时间
    private String assignStatus;   //1 新任务、2 已 提交在审核、3 审核未通过、4 审核通过

    private String acceptedList;//图片上传
    private String imgPath;//图片数组上传路径
    private String flieListUrl;//
    private String uardId;
    public String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setUardId(String uardId) {
        this.uardId = uardId;
    }

    public String getUardId() {

        return uardId;
    }

    public void setFlieListUrl(String flieListUrl) {
        this.flieListUrl = flieListUrl;
    }

    public String getFlieListUrl() {

        return flieListUrl;
    }

    public void setAcceptedList(String acceptedList) {
        this.acceptedList = acceptedList;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getAcceptedList() {

        return acceptedList;
    }

    public String getImgPath() {
        return imgPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCheckMember() {
        return checkMember;
    }

    public void setCheckMember(String checkMember) {
        this.checkMember = checkMember;
    }

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public String getPictureNumber() {
        return pictureNumber;
    }

    public void setPictureNumber(String pictureNumber) {
        this.pictureNumber = pictureNumber;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getAssignStatus() {
        return assignStatus;
    }

    public void setAssignStatus(String assignStatus) {
        this.assignStatus = assignStatus;
    }
}
