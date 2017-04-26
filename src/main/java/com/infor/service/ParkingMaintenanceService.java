package com.infor.service;

import java.util.List;

import com.infor.dto.UserMaintenanceDTO;
import com.infor.models.InforParking;

public interface ParkingMaintenanceService {
	public void deleteParking(UserMaintenanceDTO dto);
	public void saveParking(UserMaintenanceDTO dto);
	public void editParking(UserMaintenanceDTO dto);
	public List<InforParking> selectParking(UserMaintenanceDTO dto);
	
}	
