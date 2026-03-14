package com.lld.demo.dto.vehicle;

import java.util.concurrent.atomic.AtomicInteger;

import com.lld.demo.enums.ParkingSpotEnum;

public abstract class  Vehicle {
	
	private static final AtomicInteger x = new AtomicInteger(0); //it will give unique id everytime.
	private int id;
	private ParkingSpotEnum parkingSpotEnum;
	
	//constructor
	public Vehicle(ParkingSpotEnum parkingSpotEnum) {
		this.parkingSpotEnum = parkingSpotEnum;
		id = x.incrementAndGet();
	}

	public static AtomicInteger getX() {
		return x;
	}

	public int getId() {
		return id;
	}

	public ParkingSpotEnum getParkingSpotEnum() {
		return parkingSpotEnum;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setParkingSpotEnum(ParkingSpotEnum parkingSpotEnum) {
		this.parkingSpotEnum = parkingSpotEnum;
	}
	
	
	
	

}
