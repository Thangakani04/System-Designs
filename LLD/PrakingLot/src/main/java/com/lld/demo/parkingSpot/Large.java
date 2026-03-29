package com.lld.demo.parkingSpot;

public class Large extends ParkingSpot{

	public Large(Integer floor) {
		super(floor, 30);
		
	}

	@Override
	public int cost(int parkinghours) {
		return parkinghours*amount;
	}

}
