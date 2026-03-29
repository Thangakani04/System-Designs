package com.lld.demo.parkingSpot;

public class Mini extends ParkingSpot {

	public Mini(Integer floor) {
		super(floor, 10);
		
	}

	@Override
	public int cost(int parkinghours) {
		return parkinghours*amount;
	}

}
