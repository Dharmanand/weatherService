package com.example.weather.entity;



public class Weather {

	 private Integer temperature;
	 private String shortForecast;
	 
	 public Weather() {
		 
	 }
	 
	 
	public Weather(Integer temperature, String shortForecast) {
		this.temperature = temperature;
		this.shortForecast = shortForecast;
	}
	public Integer getTemperature() {
		return temperature;
	}
	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}
	public String getShortForecast() {
		return shortForecast;
	}
	public void setShortForecast(String shortForecast) {
		this.shortForecast = shortForecast;
	}
	 
	 
	
}
