package com.lld.demo.enums;

import com.lld.demo.parkingSpot.*;

public enum ParkingSpotEnum {
	
	COMPACT(Compact.class),
	MINI(Mini.class),
	LARGE(Large.class);
	

	private Class parkingSpot;
	
	ParkingSpotEnum(Class parkingSpot){
		this.parkingSpot = parkingSpot;
	}
	
	public Class getParkingSpot() {
		return parkingSpot;
	}
	
	

}
