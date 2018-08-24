package com.cloth.clothes.controller;

import com.cloth.clothes.bean.BaseResponse;

public class BaseController {

    protected BaseResponse faild(String errorMsg) {
        return faild(errorMsg, 0);
    }

    protected BaseResponse faild(String errorMsg, int code) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus("faild");
        baseResponse.setMsg(errorMsg);
        baseResponse.setCode(code);
        return baseResponse;
    }

    protected <T> BaseResponse<T> success(T t) {
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setContent(t);
        baseResponse.setCode(1);
        baseResponse.setMsg("成功！");
        baseResponse.setStatus("SUCCESS");
        return baseResponse;
    }
}
