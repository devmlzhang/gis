package com.ryoma.gis.service;

/**
 * <p>
 *  mqtt消息
 * </p>
 *
 * @author ML.Zhang
 * @since 2018/11/24
 */
public interface MqttClientService {
    void sendMessage(String topicName, String data);

    String getTopicName(String type, String name);

}
