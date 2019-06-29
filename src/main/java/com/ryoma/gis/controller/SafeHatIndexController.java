package com.ryoma.gis.controller;

import com.alibaba.fastjson.JSONObject;
import com.ryoma.gis.utils.NumToStringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *  页面跳转
 * </p>
 *
 * @author ML.Zhang
 * @since 2018/11/21
 */
@Controller
public class SafeHatIndexController {
    private Logger Log= LoggerFactory.getLogger(SafeHatIndexController.class);

    @Value("${websocket_hostname}")
    private String hostName;
    @Value("${websocket_port}")
    private String port;
    @Value("${mqtt_clientId}")
    private String mqttClientId;
    @Value("${safeRadius}")
    private String safeRadius;



    @RequestMapping("/hat")
    public String  index(Model modelMap, String projId,String projAddress,String radius){

        Log.info("projId:"+projId);
        Log.info("projAddress:"+projAddress);
        Log.info("radius:"+radius);
        Log.info("默认safeRadius:"+safeRadius);

       // JSONObject projLonLat=new JSONObject();//工地经纬度
        modelMap.addAttribute("siteMap","GOS");//离线地图 标志
        modelMap.addAttribute("projId",projId);
        modelMap.addAttribute("projCity",projAddress);
       // modelMap.addAttribute("projLonLat",projLonLat);//工地经纬度
        modelMap.addAttribute("hostName",hostName);
        modelMap.addAttribute("mqttClientId",mqttClientId);
        modelMap.addAttribute("mqttPort",port);
      //  modelMap.addAttribute("hatlocation",JSONObject.toJSON(location));
        String projTopic = NumToStringUtil.numToString(Long.valueOf("7730596820333821952"));
        modelMap.addAttribute("projTopic",projTopic);
        return "hat";
    }

    @RequestMapping("/baidu")
    public String  baidu(Model modelMap){
        modelMap.addAttribute("hostName",hostName);
        modelMap.addAttribute("mqttClientId",mqttClientId);
        modelMap.addAttribute("mqttPort",port);
        return "baidu";
    }



}
