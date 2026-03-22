package com.lld.demo.interfaces;

import com.lld.demo.dto.ParkingEvent;

public interface Observer {
	
	void update(ParkingEvent parkingEvent);

}
