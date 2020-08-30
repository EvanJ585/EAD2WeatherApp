package com.example.ead2weather;

public class WeatherReportModel {

    private int id;
    private String weatherCityName;
    private String weatherCurrentCondition;
    private int weatherMinTemp;
    private int weatherMaxTemp;
    private String weatherWindDirection;
    private int weatherWindSpeed;
    private String weatherOutlook;

//    public WeatherReportModel(int id, String weatherCityName, String weatherCurrentCondition, int weatherMinTemp, int weatherMaxTemp, String weatherWindDirection, int weatherWindSpeed, String weatherOutlook) {
//        this.id = id;
//        this.weatherCityName = weatherCityName;
//        this.weatherCurrentCondition = weatherCurrentCondition;
//        this.weatherMinTemp = weatherMinTemp;
//        this.weatherMaxTemp = weatherMaxTemp;
//        this.weatherWindDirection = weatherWindDirection;
//        this.weatherWindSpeed = weatherWindSpeed;
//        this.weatherOutlook = weatherOutlook;
//    }

    public WeatherReportModel() {
    }

    @Override
    public String toString() {
        return weatherCityName + '\n' +
                "The current weather conditions is " + weatherCurrentCondition + '\n' +
                "The Minimum Temperature is " + weatherMinTemp + "°C" + '\n' +
                "The Maximum Temperature is " + weatherMaxTemp +  "°C" + '\n' +
                "The Current Wind Direction is " + weatherWindDirection + '\n' +
                "The wind speed is " + weatherWindSpeed +  "KM/h" + '\n' +
                "The Outlook for tomorrow is " + weatherOutlook + '\n';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeatherCityName() {
        return weatherCityName;
    }

    public void setWeatherCityName(String weatherCityName) {
        this.weatherCityName = weatherCityName;
    }

    public String getWeatherCurrentCondition() {
        return weatherCurrentCondition;
    }

    public void setWeatherCurrentCondition(String weatherCurrentCondition) {
        this.weatherCurrentCondition = weatherCurrentCondition;
    }

    public int getWeatherMinTemp() {
        return weatherMinTemp;
    }

    public void setWeatherMinTemp(int weatherMinTemp) {
        this.weatherMinTemp = weatherMinTemp;
    }

    public int getWeatherMaxTemp() {
        return weatherMaxTemp;
    }

    public void setWeatherMaxTemp(int weatherMaxTemp) {
        this.weatherMaxTemp = weatherMaxTemp;
    }

    public String getWeatherWindDirection() {
        return weatherWindDirection;
    }

    public void setWeatherWindDirection(String weatherWindDirection) {
        this.weatherWindDirection = weatherWindDirection;
    }

    public int getWeatherWindSpeed() {
        return weatherWindSpeed;
    }

    public void setWeatherWindSpeed(int weatherWindSpeed) {
        this.weatherWindSpeed = weatherWindSpeed;
    }

    public String getWeatherOutlook() {
        return weatherOutlook;
    }

    public void setWeatherOutlook(String weatherOutlook) {
        this.weatherOutlook = weatherOutlook;
    }
}
