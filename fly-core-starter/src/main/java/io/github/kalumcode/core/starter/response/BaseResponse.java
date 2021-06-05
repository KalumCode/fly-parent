package com.ggread.core.starter.response;

import com.ggread.core.starter.enums.ResponseEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: duanxiaoyong
 * @create: 2020/3/8
 **/
@Data
@ApiModel(description = "返回数据")
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = -3032060746893382446L;

    // 错误码
    @ApiModelProperty("错误码,0=一切正常,1xxx=请求端参数异常,2xxx=请求端权限异常,3xxx=请求端其他异常,4xxx=网关异常,5xxx=服务端异常")
    private Integer code;

    // 提示信息
    @ApiModelProperty("提示信息")
    private String msg;

    // 返回的数据对象
    @ApiModelProperty("返回的数据对象")
    private T data;

    public BaseResponse() {
    }

    public BaseResponse(T data, Integer code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public static BaseResponse returnSuccess() {
        return returnSuccess(ResponseEnum.SUCCESS, null);
    }

    public static <T> BaseResponse<T> returnSuccess(T object) {
        return returnSuccess(ResponseEnum.SUCCESS, object);
    }

    public static BaseResponse returnSuccess(String key, Object object) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, object);
        return returnSuccess(ResponseEnum.SUCCESS, map);
    }

    public static BaseResponse returnSuccess(ResponseEnum responseEnum, Object object) {
        BaseResponse BaseResponse = new BaseResponse();
        BaseResponse.setCode(responseEnum.getCode());
        BaseResponse.setMsg(responseEnum.getMsg());
        BaseResponse.setData(object);
        return BaseResponse;
    }


    public static BaseResponse returnFail(Integer code, String msg, Object... args) {
        BaseResponse BaseResponse = new BaseResponse();
        BaseResponse.setCode(code);
        BaseResponse.setMsg(MessageFormat.format(msg, args));
        return BaseResponse;
    }


    public static BaseResponse returnFail() {
        return returnFail(ResponseEnum.FAIL);
    }

    public static BaseResponse returnFail(ResponseEnum resultEnum) {
        return returnFail(resultEnum.getCode(), resultEnum.getMsg());
    }

    public static BaseResponse returnFail(ResponseEnum resultEnum, String msg, Object... args) {
        return returnFail(resultEnum.getCode(), MessageFormat.format(msg, args));
    }

    public static BaseResponse returnFail(String msg, Object... args) {
        return returnFail(ResponseEnum.FAIL.getCode(), MessageFormat.format(msg, args));
    }


}
