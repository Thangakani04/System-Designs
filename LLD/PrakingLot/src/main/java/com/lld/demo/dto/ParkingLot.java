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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EntrancePanel> getEntrancePanels() {
		return entrancePanels;
	}

	public void setEntrancePanels(List<EntrancePanel> entrancePanels) {
		this.entrancePanels = entrancePanels;
	}

	public List<ExitPanel> getExitPanels() {
		return exitPanels;
	}

	public void setExitPanels(List<ExitPanel> exitPanels) {
		this.exitPanels = exitPanels;
	}

	public DisplayBoard getDisplayBoard() {
		return displayBoard;
	}

	public void setDisplayBoard(DisplayBoard displayBoard) {
		this.displayBoard = displayBoard;
	}

	public Map<ParkingSpotEnum, List<ParkingSpot>> getFreeParkingSpots() {
		return freeParkingSpots;
	}

	public void setFreeParkingSpots(Map<ParkingSpotEnum, List<ParkingSpot>> freeParkingSpots) {
		this.freeParkingSpots = freeParkingSpots;
	}

	public Map<ParkingSpotEnum, List<ParkingSpot>> getOccupiedParkingSpots() {
		return occupiedParkingSpots;
	}

	public void setOccupiedParkingSpots(Map<ParkingSpotEnum, List<ParkingSpot>> occupiedParkingSpots) {
		this.occupiedParkingSpots = occupiedParkingSpots;
	}

	public static ParkingLot getParkingLot() {
		return parkingLot;
	}

	public static void setParkingLot(ParkingLot parkingLot) {
		ParkingLot.parkingLot = parkingLot;
	}
	
	

}
