package com.lld.demo.ParkingStrategy;

import java.util.List;

import com.lld.demo.dto.ParkingLot;
import com.lld.demo.enums.ParkingSpotEnum;
import com.lld.demo.exceptions.SpotNotFoundException;
import com.lld.demo.parkingSpot.ParkingSpot;

public class FarthestFirstParkingStrategy implements Strategy {

	@Override
	public ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFoundException {
		List<ParkingSpot> parkingSpots = ParkingLot.getInstance().getFreeParkingSpots().get(parkingSpotEnum);
		if(parkingSpots.size() ==0) {
			throw new SpotNotFoundException("Spot not found in farthest first strategy");
		}
		
		return parkingSpots.get(parkingSpots.size()-1); //return the last one
	}

}
