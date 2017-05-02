package com.infor.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infor.dto.MaintenanceDTO;
import com.infor.models.AjaxResponseBody;
import com.infor.service.ParkingMaintenanceService;

@RestController
public class ParkingMaintenanceEndpoint {

	@Autowired
	private ParkingMaintenanceService s;
	
	@PostMapping("/selectparking")
	public MaintenanceDTO selectParking(@RequestBody MaintenanceDTO dto){
		MaintenanceDTO returndto = new MaintenanceDTO();
		returndto.setInforParkings(s.selectParking(dto));
		return returndto;
	}
	
	@PostMapping("/deleteparking")
	public AjaxResponseBody deleterole(@RequestBody MaintenanceDTO dto){
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
	
	@PostMapping("/saveparking")
	public AjaxResponseBody saverole(@RequestBody MaintenanceDTO dto){
		AjaxResponseBody response = new AjaxResponseBody();
		try{
			s.saveParking(dto);
			response.setMsg("success");
			response.setCode("200");
		}catch(Exception e){
			response.setMsg("failed");
			response.setCode("400");
		}
		return response;
	}
}
