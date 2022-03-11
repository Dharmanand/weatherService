package com.example.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weather.entity.Weather;
import com.example.weather.service.WeatherService;

@RestController
@RequestMapping
public class WeatherController {
	
	@Autowired
	WeatherService service;
	
	@GetMapping("/weather")
	public List<Weather> weatherEndpoint() {
		return service.getWeatherData();
	}
}
