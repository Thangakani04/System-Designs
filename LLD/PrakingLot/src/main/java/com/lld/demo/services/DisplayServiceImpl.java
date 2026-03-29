package com.lld.demo.services;

import com.lld.demo.dto.DisplayBoard;
import com.lld.demo.dto.ParkingEvent;
import com.lld.demo.enums.ParkingEventType;
import com.lld.demo.enums.ParkingSpotEnum;
import com.lld.demo.interfaces.DisplayService;
import com.lld.demo.interfaces.Observer;

import ch.qos.logback.core.spi.ConfigurationEvent.EventType;

public class DisplayServiceImpl implements DisplayService , Observer {

	/*@Override
	public void update(ParkingSpotEnum parkingSpotEnum, int change) {
		//we have to update the free spot counts here
		int currentcount = DisplayBoard.getInstance().getFreeParkingSpots().get(parkingSpotEnum);
		int newCount =currentcount+change;
		DisplayBoard.getInstance().getFreeParkingSpots().replace(parkingSpotEnum, newCount);
		
	}*/

	@Override
	public void update(ParkingEvent parkingEvent) {
		int currentcount = DisplayBoard.getInstance().getFreeParkingSpots().get(parkingEvent.getParkingSpotEnum());
		int change=0;
		if(parkingEvent.getParkingEventType().equals(ParkingEventType.ENTRY)) {
			change =-1;
		}
		else {
			change=1;
		}
		
		int newCount = currentcount+change;
		DisplayBoard.getInstance().getFreeParkingSpots().replace(parkingEvent.getParkingSpotEnum(), newCount);
		return;
		
	}

	
	public void update(ParkingSpotEnum parkingSpotEnum, int change) {
		Integer currentCount = DisplayBoard.getInstance().getFreeParkingSpots().get(parkingSpotEnum);
		if(currentCount == null) {
			currentCount=0;
		}
		int newCount = currentCount+change;
		DisplayBoard.getInstance().getFreeParkingSpots().replace(parkingSpotEnum, newCount);
		return;

		
	}
}
