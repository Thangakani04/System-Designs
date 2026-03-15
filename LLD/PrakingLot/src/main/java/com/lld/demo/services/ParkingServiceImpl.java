package com.lld.demo.services;

import java.util.List;

import com.lld.demo.ParkingStrategy.Strategy;
import com.lld.demo.dto.ParkingLot;
import com.lld.demo.dto.ParkingTicket;
import com.lld.demo.dto.vehicle.Vehicle;
import com.lld.demo.enums.ParkingSpotEnum;
import com.lld.demo.exceptions.InvalidTicketException;
import com.lld.demo.exceptions.SpotNotFoundException;
import com.lld.demo.interfaces.DisplayService;
import com.lld.demo.interfaces.ParkingService;
import com.lld.demo.parkingSpot.ParkingSpot;

public class ParkingServiceImpl implements ParkingService {

	//every parking service will have a strategy
	Strategy parkingStrategy;
	ParkingLot parkingLot;
	DisplayService displayService;
	
	public ParkingServiceImpl(Strategy parkingStrategy) {
		this.parkingStrategy = parkingStrategy;
		parkingLot = parkingLot.getInstance();
		displayService= new DisplayServiceImpl();
	}

	@Override
	public ParkingTicket entry(Vehicle vehicle) {
		//1. get the parking spot enum from the vehicle
		ParkingSpotEnum parkingSpotEnum = vehicle.getParkingSpotEnum();
		List<ParkingSpot> freeParkingSpots = parkingLot.getFreeParkingSpots().get(parkingSpotEnum);
		List<ParkingSpot> occupiedParkingSpots = parkingLot.getOccupiedParkingSpots().get(parkingSpotEnum);

		
		//if parking spot is not there or paring spots are filled we have to raise an exception
		try {
			ParkingSpot parkingSpot = parkingStrategy.findParkingSpot(parkingSpotEnum);
			
			//updating parking spot
			//multithreading scenario
			if(parkingSpot.isFree()) {
				synchronized(parkingSpot) {
					if(parkingSpot.isFree()) {
						parkingSpot.setFree(true);
						//we have to remove it from the parking spot in the parking lot
						freeParkingSpots.remove(parkingSpot);
						occupiedParkingSpots.add(parkingSpot);
						ParkingTicket parkingTicket = new ParkingTicket(vehicle, parkingSpot);
						//we have to call display service which will update display board.
						displayService.update(parkingSpotEnum, -1);
						return parkingTicket;
					}
					entry(vehicle);
				}
				
			}
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
	private void addParkingSpotInFreeList( List<ParkingSpot> parkingSpots , ParkingSpot parkingSpot) {
		parkingSpots.add(parkingSpot);
		
	}

	@Override
	public int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws InvalidTicketException {
		
		if(parkingTicket.getVehicle().equals(vehicle)) {
			ParkingSpot parkingSpot = parkingTicket.getParkingSpot();
			int amount = parkingSpot.getAmount();
			parkingSpot.setFree(true);
			parkingLot.getOccupiedParkingSpots().get(vehicle.getParkingSpotEnum()).remove(parkingSpot);
			//after removed from occupied we have to keep it in right place , use binary search
			displayService.update(vehicle.getParkingSpotEnum(), 1);
			return amount;
			
		}
		else {
			throw new InvalidTicketException("This is an invalid Ticket");
		}
		
	}

}
