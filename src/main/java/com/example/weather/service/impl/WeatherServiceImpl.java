package com.example.weather.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.weather.entity.Period;
import com.example.weather.entity.Weather;
import com.example.weather.service.WeatherService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherServiceImpl implements WeatherService {

	private final static String WEATHER_URL = "https://api.weather.gov/gridpoints/TOP/31,80/forecast";

	@Autowired
	WebClient.Builder builder;
	
	@Override
	public List<Weather> getWeatherData() {
		//Map<String, Object> map = new RestTemplate().getForObject(WEATHER_URL, Map.class);
		Map<String, Object> map = builder.build().get().uri(WEATHER_URL).retrieve().bodyToMono(Map.class).block();
		List<Period> pList = (List<Period>) ((Map<String, Object>) map.get("properties")).get("periods");
		
		List<Period> periodList = new ObjectMapper().convertValue(pList, new TypeReference<List<Period>>() {
		});
		List<Weather> weatherList = new ArrayList<>();
		for (Period period : periodList) {
			Weather weather = new Weather(period.getTemperature(), period.getShortForecast());
			weatherList.add(weather);
		}
		return weatherList;
	}

}
