package com.infor.dao;

import java.util.List;

import com.infor.dto.MaintenanceDTO;
import com.infor.models.InforParking;

public interface ParkingMaintananceDao {
	public void deleteParking(MaintenanceDTO dto);
	public void saveParking(InforParking inforParking);
	public void editParking(InforParking inforParking);
	public List<InforParking> selectParking(MaintenanceDTO dto);
	
	public List<InforParking> selectAllParking();
	
}
