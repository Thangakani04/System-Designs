package com.lld.demo.parkingSpot.spotDecorator;

import com.lld.demo.parkingSpot.ParkingSpot;

public abstract class SpotDecorator extends ParkingSpot {
	
	protected ParkingSpot parkingSpot;

	public SpotDecorator(ParkingSpot parkingSpot) {
		this.parkingSpot = parkingSpot;
	}
	
	

}
