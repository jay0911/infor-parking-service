package com.infor.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infor.dto.UserMaintenanceDTO;
import com.infor.service.ParkingMaintenanceService;

@RestController
public class ParkingMaintenanceEndpoint {

	@Autowired
	private ParkingMaintenanceService s;
	
	@PostMapping("/selectparking")
	public UserMaintenanceDTO selectParking(@RequestBody UserMaintenanceDTO dto){
		UserMaintenanceDTO returndto = new UserMaintenanceDTO();
		returndto.setInforParkings(s.selectParking(dto));
		return returndto;
	}
}
