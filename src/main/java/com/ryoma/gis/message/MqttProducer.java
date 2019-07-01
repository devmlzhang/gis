package com.ryoma.gis.message;

import com.alibaba.fastjson.JSONObject;
import com.ryoma.gis.model.MsgModel;
import com.ryoma.gis.service.MqttClientService;
import com.ryoma.gis.utils.NumToStringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@EnableScheduling
public class MqttProducer {
    private final static Logger logger= LoggerFactory.getLogger(MqttProducer.class);
    /**
     * 定时发送主题消息
     */

    @Autowired
    MqttClientService mqttClientService;


    @Scheduled(fixedDelay = 3000)
    public void send() {
        String msg = "消息发送模拟";
        String TOPIC = NumToStringUtil.numToString(Long.valueOf("7730596820333821952"));
        if (msg != null) {
            try {
                    //102.838215  24.95089
                   //119.405550,39.920506
                    JSONObject mqParams= new JSONObject();
                    mqParams.put("projId","7730596820333821952");
                    mqParams.put("userId","359972069698238");
                    mqParams.put("longitude",119.40555+Math.random()*0.0001);
                    mqParams.put("latitude",39.92050+Math.random()*0.0001);
                    MsgModel msgModel = new MsgModel();
                    msgModel.setData(mqParams);
                    msgModel.setMsgType("A");
                    logger.info("发送到AMQ："+JSONObject.toJSONString(msgModel));
                    mqttClientService.sendMessage(TOPIC, JSONObject.toJSONString(msgModel));
               // }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


}
