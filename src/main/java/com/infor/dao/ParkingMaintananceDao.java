package com.infor.dao;

import java.util.List;

import com.infor.dto.UserMaintenanceDTO;
import com.infor.models.InforParking;

public interface ParkingMaintananceDao {
	public void deleteParking(UserMaintenanceDTO dto);
	public void saveParking(InforParking inforParking);
	public void editParking(InforParking inforParking);
	public List<InforParking> selectParking(UserMaintenanceDTO dto);
	
	public List<InforParking> selectAllParking();
	
}
