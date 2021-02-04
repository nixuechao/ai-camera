package com.gishere.aicamera.config.http;

import cn.hutool.core.codec.Base64;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.gishere.aicamera.config.http.domain.other.AuthResult;
import com.gishere.aicamera.config.http.domain.other.IpcRep;
import com.gishere.aicamera.config.http.domain.push.PushData;
import com.gishere.aicamera.config.http.handle.ProcessHandler;
import com.gishere.aicamera.config.mqtt.ConnectionProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 暴露的服务端点
 *
 * @author niXueChao
 * @date 2021/2/4.
 */
@Slf4j
@RestController
@RequestMapping("/ipc")
public class Endpoint {

    private final ProcessHandler camPushDataProcessHandler;
    private final ConnectionProperty mqttConnectionProperty;

    public Endpoint(ProcessHandler camPushDataProcessHandler, ConnectionProperty mqttConnectionProperty) {
        this.camPushDataProcessHandler = camPushDataProcessHandler;
        this.mqttConnectionProperty = mqttConnectionProperty;
    }

    /**
     * 数据推送端点
     */
    @PostMapping("/data/push")
    public IpcRep dataPush(@RequestBody PushData pushData) {
        try {
            camPushDataProcessHandler.process(pushData);
        } catch (Exception e) {
            log.error("IPC数据处理失败", e);
            return IpcRep.success();
        }
        return IpcRep.success();
    }

    /**
     * IPC认证
     */
    @PostMapping(value = "/auth")
    public IpcRep auth(@RequestBody String body) {
        String deviceSn = JSONUtil.parseObj(body).getStr("device_sn");
        AuthResult rep = new AuthResult(deviceSn, mqttConnectionProperty.getUri(), mqttConnectionProperty.getUsername(), mqttConnectionProperty.getPassword());
        return IpcRep.success(rep);
    }


    /**
     * 获取IPC配置所需的token(接入URL)
     */
    @GetMapping("/token")
    public String getToken(@RequestParam String authUrl) {
        JSONObject body = new JSONObject();
        body.set("schema", "schema_ipc_passengerflow");
        JSONObject activation = new JSONObject();
        activation.set("url", authUrl);
        activation.set("http_method", "POST");
        activation.set("body", body);

        JSONObject token = new JSONObject();
        token.set("activation", activation);
        return Base64.encode(JSONUtil.toJsonStr(token));
    }
}
