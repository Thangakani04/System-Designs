package com.lld.demo.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lld.demo.enums.ParkingSpotEnum;
import com.lld.demo.parkingSpot.ParkingSpot;

public class ParkingLot { //singleton class
	
	private String name;
	private List<EntrancePanel> entrancePanels;
	private List<ExitPanel> exitPanels;
	private DisplayBoard displayBoard;
	private Map<ParkingSpotEnum, List<ParkingSpot>> freeParkingSpots;
	private Map<ParkingSpotEnum, List<ParkingSpot>> occupiedParkingSpots;
	
	private static ParkingLot parkingLot = null;
	
	private ParkingLot(String name) { //private constructor
		this.name =name;
		entrancePanels = new ArrayList<>();
		exitPanels = new ArrayList<>();
		displayBoard = DisplayBoard.getInstance();
		freeParkingSpots = new HashMap<>();
		occupiedParkingSpots = new HashMap<>();
	}
	
	public static ParkingLot getInstance() {
		if(parkingLot ==null) {
			parkingLot = new ParkingLot("Wave");
		}
		return parkingLot;
	}

}
