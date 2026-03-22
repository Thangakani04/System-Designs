package com.lld.demo.dto;

import com.lld.demo.enums.ParkingEventType;
import com.lld.demo.enums.ParkingSpotEnum;

public class ParkingEvent {
	
	private ParkingEventType parkingEventType;
	private ParkingSpotEnum parkingSpotEnum;
	
	
	public ParkingEvent(ParkingEventType parkingEventType, ParkingSpotEnum parkingSpotEnum) {
		this.parkingEventType = parkingEventType;
		this.parkingSpotEnum = parkingSpotEnum;
	}


	public ParkingEventType getParkingEventType() {
		return parkingEventType;
	}


	public void setParkingEventType(ParkingEventType parkingEventType) {
		this.parkingEventType = parkingEventType;
	}


	public ParkingSpotEnum getParkingSpotEnum() {
		return parkingSpotEnum;
	}


	public void setParkingSpotEnum(ParkingSpotEnum parkingSpotEnum) {
		this.parkingSpotEnum = parkingSpotEnum;
	}
	
	
	
	
	

}
