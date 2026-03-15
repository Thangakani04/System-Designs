package com.lld.demo.services;

import com.lld.demo.dto.DisplayBoard;
import com.lld.demo.enums.ParkingSpotEnum;
import com.lld.demo.interfaces.DisplayService;

public class DisplayServiceImpl implements DisplayService {

	@Override
	public void update(ParkingSpotEnum parkingSpotEnum, int change) {
		//we have to update the free spot counts here
		int currentcount = DisplayBoard.getInstance().getFreeParkingSpots().get(parkingSpotEnum);
		int newCount =currentcount+change;
		DisplayBoard.getInstance().getFreeParkingSpots().replace(parkingSpotEnum, newCount);
		
	}

}
