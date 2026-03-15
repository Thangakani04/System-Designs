package com.lld.demo.ParkingStrategy;

import com.lld.demo.enums.ParkingSpotEnum;
import com.lld.demo.exceptions.SpotNotFoundException;
import com.lld.demo.parkingSpot.ParkingSpot;

public interface Strategy {
	
	ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFoundException;

}
