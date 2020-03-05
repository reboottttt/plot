package com.library.utils;

/**
 * @Author: 周黎
 * @Date: 2019/11/11
 * @Description: com.library.utils
 * @version: 1.0
 */
public class Result<T> {
    /**
     * 错误码.
     */
    private Integer errorCode;

    /**
     * 提示信息.
     */
    private String errorMsg;

    /**
     * 具体的内容.
     */
    private T data;

    /**
     * 总记录数.
     */
    private int filterCount;

    public int getFilterCount() {
        return filterCount;
    }

    public void setFilterCount(int filterCount) {
        this.filterCount = filterCount;
    }

    public Integer geterrorCode() {
        return errorCode;
    }

    public void seterrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String geterrorMsg() {
        return errorMsg;
    }

    public void seterrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
