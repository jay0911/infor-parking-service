package com.infor.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infor.dto.UserMaintenanceDTO;
import com.infor.models.AjaxResponseBody;
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
	
	@PostMapping("/deleteparking")
	public AjaxResponseBody deleterole(@RequestBody UserMaintenanceDTO dto){
		AjaxResponseBody response = new AjaxResponseBody();
		try{
			s.deleteParking(dto);
			response.setMsg("success");
			response.setCode("200");
		}catch(Exception e){
			response.setMsg("failed");
			response.setCode("400");
		}
		return response;
	}
}
