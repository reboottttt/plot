package com.library.bean;

/**
 * @Author: 穆肖肖
 * @Date: 2019/11/7
 * @Description: com.library.bean
 * 任务分页
 * @version: 1.0
 */

public class TaskList {

    public String accuracy;             //正确率
    public String assignDir;            //分派目录
    public String assignNumber;         //分派数量
    public String assignTime;           //分派时间
    public String rejectReason;         //审核不通过原因
    public String reviewStatus;         //审核状态码
    public String reviewStatusMessage;  //审核状态码说明
    public String uapId;                //分派任务 ID
    public String urpId;                //审核 ID
    public String userAccount;          //标图员账号
    public String userName;             //标图员姓名

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public String getAssignDir() {
        return assignDir;
    }

    public void setAssignDir(String assignDir) {
        this.assignDir = assignDir;
    }

    public String getAssignNumber() {
        return assignNumber;
    }

    public void setAssignNumber(String assignNumber) {
        this.assignNumber = assignNumber;
    }

    public String getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(String assignTime) {
        this.assignTime = assignTime;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public String getReviewStatusMessage() {
        return reviewStatusMessage;
    }

    public void setReviewStatusMessage(String reviewStatusMessage) {
        this.reviewStatusMessage = reviewStatusMessage;
    }

    public String getUapId() {
        return uapId;
    }

    public void setUapId(String uapId) {
        this.uapId = uapId;
    }

    public String getUrpId() {
        return urpId;
    }

    public void setUrpId(String urpId) {
        this.urpId = urpId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
