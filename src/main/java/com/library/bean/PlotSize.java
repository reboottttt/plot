package com.library.bean;

import java.util.List;

/**
 * @Author: 穆肖肖
 * @Date: 2019/11/11
 * @Description: com.library.bean
 * 标图标注点位
 * @version: 1.0
 */

public class PlotSize {
    private int uardId;
    private SizeDO size;
    private String filename;
    private List<PlotDataDO> plotData;
    private String status;//1为标注

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUardId() {
        return uardId;
    }

    public void setUardId(int uardId) {
        this.uardId = uardId;
    }

    public SizeDO getSize() {
        return size;
    }

    public void setSize(SizeDO size) {
        this.size = size;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<PlotDataDO> getPlotData() {
        return plotData;
    }

    public void setPlotData(List<PlotDataDO> plotData) {
        this.plotData = plotData;
    }

    public static class SizeDO{

        private int width;
        private int height;
        private int depth;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getDepth() {
            return depth;
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }
    }

    public static class PlotDataDO {
        private String name;
        private String pIndex;
        private List<List<Double>> bndbox;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getpIndex() {
            return pIndex;
        }

        public void setpIndex(String pIndex) {
            this.pIndex = pIndex;
        }

        public List<List<Double>> getBndbox() {
            return bndbox;
        }

        public void setBndbox(List<List<Double>> bndbox) {
            this.bndbox = bndbox;
        }
    }
}
