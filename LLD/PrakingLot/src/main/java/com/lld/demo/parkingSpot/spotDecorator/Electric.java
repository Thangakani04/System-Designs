package com.lld.demo.parkingSpot.spotDecorator;

import com.lld.demo.parkingSpot.ParkingSpot;

public class Electric extends SpotDecorator {

	public Electric(ParkingSpot parkingSpot) {
		super(parkingSpot);
	}

	@Override
	public int cost(int parkinghours) {
		return parkingSpot.cost(parkinghours)+50 ;
	}

}
