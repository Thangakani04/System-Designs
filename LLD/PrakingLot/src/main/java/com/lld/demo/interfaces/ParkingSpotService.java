package com.lld.demo.interfaces;

import com.lld.demo.enums.ParkingSpotEnum;
import com.lld.demo.parkingSpot.ParkingSpot;

public interface ParkingSpotService {
	
	ParkingSpot create(ParkingSpotEnum parkingSpotEnum , Integer floor);

}
