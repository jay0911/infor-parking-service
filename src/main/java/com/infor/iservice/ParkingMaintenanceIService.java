package com.infor.iservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infor.dao.ParkingMaintananceDao;
import com.infor.dto.UserMaintenanceDTO;
import com.infor.models.InforParking;
import com.infor.models.InforUser;
import com.infor.service.ParkingMaintenanceService;
/**
 * 
 * @author joliveros
 * @see InforUser
 * @since 1.0
 */
@Service
public class ParkingMaintenanceIService implements ParkingMaintenanceService{
	
	@Autowired
	private ParkingMaintananceDao md;

	@Override
	public void deleteParking(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub
		md.deleteParking(dto);
	}

	@Override
	public void saveParking(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub
		InforParking inforParking = new InforParking();
		inforParking.setIsparkingtandem(dto.getIsparkingtandem());
		inforParking.setParkingid(dto.getParkingid());
		inforParking.setUserid(-1);
		md.saveParking(inforParking);
	}

	@Override
	public void editParking(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub
		InforParking inforParking = new InforParking();
		inforParking.setIsparkingtandem(dto.getIsparkingtandem());
		inforParking.setParkingid(dto.getParkingid());
		inforParking.setUserid(dto.getUserid());
		md.editParking(inforParking);
	}

	@Override
	public List<InforParking> selectParking(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub
		return md.selectAllParking();
	}

}
