package com.lld.demo.dto;

import java.util.HashMap;
import java.util.Map;

import com.lld.demo.enums.ParkingSpotEnum;

public class DisplayBoard {
	
	//to make singleton class
	private static DisplayBoard displayBoard = null;
	private Map<ParkingSpotEnum, Integer> freeParkingSpots;
	
	//private constructor to make singleton
	
	private DisplayBoard() {
		
		this.freeParkingSpots = new HashMap<>();
	}
	
	public static DisplayBoard getInstance() {
		if (displayBoard == null) {
			displayBoard = new DisplayBoard();
		}
		return displayBoard;
	}

	public Map<ParkingSpotEnum, Integer> getFreeParkingSpots() {
		return freeParkingSpots;
	}

	public void setFreeParkingSpots(Map<ParkingSpotEnum, Integer> freeParkingSpots) {
		this.freeParkingSpots = freeParkingSpots;
	}
	
	
	

}
