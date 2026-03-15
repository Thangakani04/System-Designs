package com.lld.demo.dto;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

import com.lld.demo.dto.vehicle.Vehicle;
import com.lld.demo.parkingSpot.ParkingSpot;

public class ParkingTicket {
	
	private static final AtomicInteger x = new AtomicInteger(0);
	private int id;
	private Vehicle vehicle;
	private ParkingSpot parkingSpot;
	private  LocalDateTime timeStamp;
	
	public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
		this.vehicle = vehicle;
		this.parkingSpot = parkingSpot;
		timeStamp = LocalDateTime.now();
		id = x.incrementAndGet();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}

	public void setParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpot = parkingSpot;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public static AtomicInteger getX() {
		return x;
	}
	
	
	
	
	
	

}
