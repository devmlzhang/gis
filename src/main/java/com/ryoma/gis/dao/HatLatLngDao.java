package com.ryoma.gis.dao;


import com.ryoma.gis.pojo.HatLatLng;
import org.springframework.stereotype.Repository;

@Repository
public interface HatLatLngDao {


    int insertHatLatLng(HatLatLng record);

    HatLatLng selectByProjId(String projId);

    int updateHatLatLng(HatLatLng record);

}
