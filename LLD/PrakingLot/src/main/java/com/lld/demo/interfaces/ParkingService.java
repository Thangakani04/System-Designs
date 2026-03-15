package com.lld.demo.interfaces;

import com.lld.demo.dto.ParkingTicket;
import com.lld.demo.dto.vehicle.Vehicle;
import com.lld.demo.exceptions.InvalidTicketException;

public interface ParkingService {
	
	ParkingTicket entry(Vehicle vehicle);
	int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws InvalidTicketException;

}
