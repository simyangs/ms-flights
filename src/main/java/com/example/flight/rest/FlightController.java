package com.example.flight.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flight.dto.FlightReqDto;
import com.example.flight.dto.FlightResDto;
import com.example.flight.service.FlightService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	@GetMapping("/flights")
	public ResponseEntity<FlightResDto> getFlight(@RequestBody FlightReqDto inDto){
		log.debug(inDto.toString());
		FlightResDto outDto = flightService.getFlight(inDto);
		
		return new ResponseEntity<FlightResDto>(outDto, HttpStatus.OK);
	}
	
	@GetMapping("/flights/{flight_no}/seat_map")
	public ResponseEntity<Map<String, Object>> getSeatMap(@PathVariable("flight_no") String flight_no){
		log.debug(flight_no);
		Map<String, Object> result = flightService.getSeatMap(flight_no);
		
		return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);
	}
}
