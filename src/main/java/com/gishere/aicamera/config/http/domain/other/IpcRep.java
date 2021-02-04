package com.gishere.aicamera.config.http.domain.other;

import lombok.Data;

import java.util.UUID;

/**
 * 对ipc的响应
 *
 * @author niXueChao
 * @date 2021/2/4.
 */
@Data
public class IpcRep {
    /**
     * 用于区分每一次请求的唯一的字符串。除非发生
     * 404(API_NOT_FOUND)错误，否则此字段必定返回
     */
    private String RequestId;
    /**
     * 当前 request 返回状态码，0 表示成功，其他详见错
     * 误码
     */
    private Integer Code;
    /**
     * 当前 request 返回描述信息
     */
    private String Message;
    /**
     * 当前 request 返回的数据
     */
    private Object Data;

    public static IpcRep success() {
        IpcRep rep = new IpcRep();
        rep.setRequestId(UUID.randomUUID().toString());
        rep.setCode(0);
        rep.setMessage("success");
        return rep;
    }

    public static IpcRep success(Object data) {
        IpcRep success = success();
        success.setData(data);
        return success;
    }

}
