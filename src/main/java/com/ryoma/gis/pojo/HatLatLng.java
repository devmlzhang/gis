package com.ryoma.gis.pojo;

import java.io.Serializable;

public class HatLatLng implements Serializable {
    /**
     * 防区半径
     */
    private String projId;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 经度
     */
    private String lng;

    private Integer radius;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "HatLatLng{" +
                "projId='" + projId + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", radius=" + radius +
                '}';
    }

    public String getProjId() {
        return projId;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
