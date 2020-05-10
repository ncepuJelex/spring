package com.jel.tech.choose.model;

/**
 * @author jelex
 * @date 2020-05-09:22:55
 * @description
 **/
public class OptionalPack {

    private Integer id;

    private String featureCode;

    private String featureName;

    private String batteryLife;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(String batteryLife) {
        this.batteryLife = batteryLife;
    }

    @Override
    public String toString() {
        return "OptionalPack{" +
                "id=" + id +
                ", featureCode='" + featureCode + '\'' +
                ", featureName='" + featureName + '\'' +
                ", batteryLife='" + batteryLife + '\'' +
                '}';
    }
}
