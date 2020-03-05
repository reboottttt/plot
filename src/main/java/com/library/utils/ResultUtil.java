package com.library.utils;


/**
 * @Author: 周黎
 * @Date: 2019/11/11
 * @Description: com.library.utils
 * @version: 1.0
 */
public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();
        result.seterrorCode(0);
        result.seterrorMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result pagesuccess(Object object, int filterCount) {
        Result result = new Result();
        result.seterrorCode(0);
        result.seterrorMsg("成功");
        result.setData(object);
        result.setFilterCount(filterCount);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.seterrorCode(code);
        result.seterrorMsg(msg);
        return result;
    }
}
