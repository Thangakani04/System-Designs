package com.lld.demo.services;

import java.lang.reflect.InvocationTargetException;

import com.lld.demo.dto.ParkingLot;
import com.lld.demo.enums.ParkingSpotEnum;
import com.lld.demo.interfaces.DisplayService;
import com.lld.demo.interfaces.ParkingSpotService;
import com.lld.demo.parkingSpot.ParkingSpot;

public class ParkingSpotServiceImpl implements ParkingSpotService {
	
	DisplayService displayService = new DisplayServiceImpl();

	@Override
	public ParkingSpot create(ParkingSpotEnum parkingSpotEnum, Integer floor) {
		try {
			ParkingSpot parkingSpot = (ParkingSpot) parkingSpotEnum.getParkingSpot().getConstructor(Integer.class).newInstance(floor);
			ParkingLot.getInstance().getFreeParkingSpots().get(parkingSpotEnum).add(parkingSpot); //parking spot is added
			displayService.update(parkingSpotEnum, 1);
			return parkingSpot;
			
			
		} catch (InstantiationException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			
			e.printStackTrace();
		} catch (SecurityException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
