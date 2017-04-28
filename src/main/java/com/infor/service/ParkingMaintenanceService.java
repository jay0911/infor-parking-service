package com.infor.service;

import java.util.List;

import com.infor.dto.MaintenanceDTO;
import com.infor.models.InforParking;

public interface ParkingMaintenanceService {
	public void deleteParking(MaintenanceDTO dto);
	public void saveParking(MaintenanceDTO dto);
	public void editParking(MaintenanceDTO dto);
	public List<InforParking> selectParking(MaintenanceDTO dto);
	
}	
