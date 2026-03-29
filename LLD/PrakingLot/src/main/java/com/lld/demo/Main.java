package com.lld.demo;

import com.lld.demo.ParkingStrategy.FarthestFirstParkingStrategy;
import com.lld.demo.dto.ParkingLot;
import com.lld.demo.dto.ParkingTicket;
import com.lld.demo.dto.vehicle.Car;
import com.lld.demo.dto.vehicle.Vehicle;
import com.lld.demo.enums.ParkingSpotEnum;
import com.lld.demo.exceptions.InvalidTicketException;
import com.lld.demo.interfaces.ParkingSpotService;
import com.lld.demo.interfaces.PaymentService;
import com.lld.demo.parkingSpot.ParkingSpot;
import com.lld.demo.services.ParkingServiceImpl;
import com.lld.demo.services.ParkingSpotServiceImpl;
import com.lld.demo.services.PaymentServiceImpl;

public class Main {
	
	public static void main(String[] args) {
		
		ParkingLot parkingLot = ParkingLot.getInstance();
		ParkingSpotService parkingSpotService = new ParkingSpotServiceImpl();
		
		ParkingSpot pc1= parkingSpotService.create(ParkingSpotEnum.COMPACT, 0);
		ParkingSpot pc2= parkingSpotService.create(ParkingSpotEnum.COMPACT, 0);
		
		ParkingSpot pm1= parkingSpotService.create(ParkingSpotEnum.MINI, 0);
		ParkingSpot pm2= parkingSpotService.create(ParkingSpotEnum.MINI, 0);
		
		ParkingSpot pl1= parkingSpotService.create(ParkingSpotEnum.LARGE, 0);
		ParkingSpot pl2= parkingSpotService.create(ParkingSpotEnum.LARGE, 0);
		
		Vehicle v1 = new Car();
		Vehicle v2 = new Car();
		Vehicle v3 = new Car();
		
		//passing farthest first strategy
		
		ParkingServiceImpl parkingLotService = new ParkingServiceImpl(new FarthestFirstParkingStrategy());
		PaymentService paymentService = new PaymentServiceImpl();
		
		//make vehicle 1 entry
		
		ParkingTicket parkingTicket1 = parkingLotService.entry(v1);
		System.out.println("Parking Ticket 1 " + parkingTicket1);
		System.out.println("Parking ticket 1 with vehicle id : " + parkingTicket1.getVehicle().getId());
		System.out.println(parkingTicket1.getVehicle().equals(v1));
		
		ParkingTicket parkingTicket2 = parkingLotService.entry(v2);
		parkingLotService.addWash(parkingTicket2);
		System.out.println("Parking Ticket 2 " + parkingTicket2);
		System.out.println("Parking ticket 2 with vehicle id : " + parkingTicket2.getVehicle().getId());
		try {
			parkingLotService.exit(parkingTicket2, v2);
			int cost = parkingTicket2.getParkingSpot().cost(parkingTicket2.getParkingHours());
			System.out.println("Cost :" + cost);
			paymentService.accepCash(cost);
			
		} catch (InvalidTicketException e) {
			e.printStackTrace();
		}

		
	}

}
