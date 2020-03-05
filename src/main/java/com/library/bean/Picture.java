package com.library.bean;

/**
 * @Author: 周黎
 * @Date: 2019/11/18
 * @Description: com.library.bean
 * @version: 1.0
 */
public class Picture {
    private int uardId; //图片id
    private String fileName;//图片路径全名
    private String size;//图片大小
    private String plotData;//坐标点位
    private int uapId;//任务/样本库id
    private String finalPicturePath;//
    private String picturePath;//
    private String thumbnailPath;//
    private String checkMember;//标图人员
    private String uuid;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setUardId(int uardId) {
        this.uardId = uardId;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPlotData(String plotData) {
        this.plotData = plotData;
    }

    public void setUapId(int uapId) {
        this.uapId = uapId;
    }

    public void setFinalPicturePath(String finalPicturePath) {
        this.finalPicturePath = finalPicturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public void setCheckMember(String checkMember) {
        this.checkMember = checkMember;
    }

    public int getUardId() {

        return uardId;
    }

    public String getFileName() {
        return fileName;
    }

    public String getSize() {
        return size;
    }

    public String getPlotData() {
        return plotData;
    }

    public int getUapId() {
        return uapId;
    }

    public String getFinalPicturePath() {
        return finalPicturePath;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public String getCheckMember() {
        return checkMember;
    }
}
