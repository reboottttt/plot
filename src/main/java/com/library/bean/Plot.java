package com.library.bean;

import java.util.Date;

/**
 * @Author: 穆肖肖
 * @Date: 2019/11/7
 * @Description: com.library.bean
 * 任务分页
 * @version: 1.0
 */

public class Plot {

    public String id;                   //uap id
    public String assignDate;           //分配时间
    public String assignStatus;         //图片状态（1新任务、2审核通过、3提交在审核 ）
    public String assignStatusZHCN;     //分配状态说明
    public String gmtCreate;            //任务创建时间
    public String userId;                //用户分配的ID
    public String pictureCatalog;       //图片所属目录（多层，/分隔）
    public String pictureNumber;        //图片数量
    public int plotNum;              //已标注数量
    public String reviewOpinion;        //审核意见
    public String sampleName;           //任务名称
    public String filename;	            //原图全路径的文件名
    public String finalPicturePath;     //原图标注后重命名图片访问 URL （图片暂未标注时取原图名称）
    public String picturePath;          //图片（去除 exif）访问 URL
    public String plotData; 	        //标注数据数组对象的 JSON 串
    public String thumbnailPath;        //原图缩略图（去除 exif）访问 URL
    public String uardId;	            //用户分配审核 ID
    public String uapId;                //分派任务 ID
    public String urpId;                //审核任务 ID

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(String assignDate) {
        this.assignDate = assignDate;
    }

    public String getAssignStatus() {
        return assignStatus;
    }

    public void setAssignStatus(String assignStatus) {
        this.assignStatus = assignStatus;
    }

    public String getAssignStatusZHCN() {
        return assignStatusZHCN;
    }

    public void setAssignStatusZHCN(String assignStatusZHCN) {
        this.assignStatusZHCN = assignStatusZHCN;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPictureCatalog() {
        return pictureCatalog;
    }

    public void setPictureCatalog(String pictureCatalog) {
        this.pictureCatalog = pictureCatalog;
    }

    public String getPictureNumber() {
        return pictureNumber;
    }

    public void setPictureNumber(String pictureNumber) {
        this.pictureNumber = pictureNumber;
    }

    public int getPlotNum() {
        return plotNum;
    }

    public void setPlotNum(int plotNum) {
        this.plotNum = plotNum;
    }

    public String getReviewOpinion() {
        return reviewOpinion;
    }

    public void setReviewOpinion(String reviewOpinion) {
        this.reviewOpinion = reviewOpinion;
    }

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFinalPicturePath() {
        return finalPicturePath;
    }

    public void setFinalPicturePath(String finalPicturePath) {
        this.finalPicturePath = finalPicturePath;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getPlotData() {
        return plotData;
    }

    public void setPlotData(String plotData) {
        this.plotData = plotData;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public String getUardId() {
        return uardId;
    }

    public void setUardId(String uardId) {
        this.uardId = uardId;
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
}
