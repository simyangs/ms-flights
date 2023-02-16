package com.example.flight.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flight.dto.FlightReqDto;
import com.example.flight.dto.FlightResDto;
import com.example.flight.repo.FlightRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	public FlightResDto getFlight(FlightReqDto inDto) {
		return flightRepository.getFlight(inDto);
	}
	
	public Map<String, Object> getSeatMap(String flight_no){
		String result = flightRepository.getSeatMap(flight_no);
		ObjectMapper om = new ObjectMapper();
		Map<String, Object> jsonMap = null;
		try {
			jsonMap = om.readValue(result, new TypeReference<Map<String, Object>>() {});
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
		
		
	}
}
