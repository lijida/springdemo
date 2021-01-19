package com.demo.mqtt.controller;

import com.demo.mqtt.service.MqttSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mqtt")
public class MessageSendController {
    @Autowired
    private MqttSender mqttSender;

    /***
     * 发布消息，用于其他客户端消息接收测试
     */
    @PostMapping("sendMqttMessage")
    public String sendMqttMessage(String message, String topic) {
        mqttSender.sendToMqtt(message, topic);
        return "ok";
    }
}
