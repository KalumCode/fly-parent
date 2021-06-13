package io.github.kalumcode.fly.core.starter.log;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 日志统计打点工具类
 *
 * @Author: Kalum
 * @Date: 2021/6/6 8:52 上午
 * Version List
 * 版本        修改人        修改日期           修改描述
 * ------------------------------------------------------------
 * 1.0.0       Kalum       2021/6/6 8:52 上午   create
 * ------------------------------------------------------------
 */
public final class TraceUtil {

    private static final Logger logTrace = LoggerFactory.getLogger("sys_trace");

    public static void info(String eventName, BaseTraceDTO baseTraceDTO) {
        info(eventName, Arrays.asList(baseTraceDTO));
    }

    public static void info(String eventName, List<BaseTraceDTO> baseTraceDTO) {
        TraceCommonFieldDTO commonField = getCommonField();

        baseTraceDTO.stream().forEach(msg -> {
            JSONObject eventJson = new JSONObject();
            eventJson.putOpt("time", DateTime.now().toString());
            eventJson.putOpt("name", eventName);
            eventJson.putOpt("kv", msg);

            JSONObject json = new JSONObject();
            json.putOpt("common", commonField);
            json.putOpt("actions", eventJson);
            logTrace.info(JSONUtil.toJsonStr(json));
        });
    }

    private static TraceCommonFieldDTO getCommonField() {
        //TODO 需改成当前用户id
        Long currentMemberId = 1001L;
        TraceCommonFieldDTO dto = new TraceCommonFieldDTO();
        dto.setMemberId(currentMemberId);
        dto.setSource(LogSourceEnum.APP.getMsg());
        return dto;
    }
}
