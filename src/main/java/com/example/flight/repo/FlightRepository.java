package com.example.flight.repo;

import org.apache.ibatis.annotations.Mapper;

import com.example.flight.dto.FlightReqDto;
import com.example.flight.dto.FlightResDto;

@Mapper
public interface FlightRepository {
	public FlightResDto getFlight(FlightReqDto inDto);
	
	public String getSeatMap(String flight_no);
}
