package com.lld.demo.parkingSpot;

public class Compact extends ParkingSpot{

	public Compact(Integer floor) {
		super(floor, 20);
		
	}

	@Override
	public int cost(int parkinghours) {
		return parkinghours*amount;
	}

}
