package com.infor.idao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import com.infor.dao.ParkingMaintananceDao;
import com.infor.dto.MaintenanceDTO;
import com.infor.models.InforParking;
import com.infor.models.InforUser;


@Repository
@Transactional
public class ParkingMaintenanceIDao extends HibernateDaoSupport implements ParkingMaintananceDao{
	
	private static final String PARKING_FETCHALL_HQL = "select distinct ip.parkingid,ip.isparkingtandem from InforParking ip";
	//private static final String PARKING_MODIFY_HQL = "update InforParking set isparkingtandem=:isparkingtandem, userid=:userid where parkingid=:parkingid and userid=:olduserid";
	private static final String PARKING_DELETE_HQL = "delete from InforParking where parkingid=:parkingid";
	private static final String PARKING_FETCHUSER = "select distinct ip.userid,iu.firstname,iu.lastname,iu.position,iu.contactnumber,iu.emailaddress,iu.inforaddress from tbl_inforparking ip join tbl_inforuser iu on ip.userid = iu.userid where ip.parkingid=:parkingid";	

	@Override
	public void deleteParking(MaintenanceDTO dto) {
		// TODO Auto-generated method stub
		
		Query query = getSessionFactory().createQuery(PARKING_DELETE_HQL);
	    query.setParameter("parkingid", dto.getParkingid());
	    int deleted = query.executeUpdate();
	    System.out.println("Deleted: " + deleted + " ParkingInfo(s)");
	}

	@Override
	public void saveParking(InforParking inforParking) {
		// TODO Auto-generated method stub
		getSessionFactory().save(inforParking);
	}

	@Override
	public void editParking(InforParking inforParking) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<InforParking> selectParking(MaintenanceDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InforParking> selectAllParking() {
		List<InforParking> ip = new ArrayList<InforParking>();
		List<Object[]> plainObj = customSelectQuery(PARKING_FETCHALL_HQL).list();
		
		for(Object[] obj: plainObj){
			InforParking inforParking = new InforParking();
			inforParking.setParkingid((String)obj[0]);
			inforParking.setIsparkingtandem((String)obj[1]);
			ip.add(inforParking);
		}	
		return ip;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InforUser> selectParkingUser(InforParking infparking) {
		// TODO Auto-generated method stub
		List<InforUser> iu = new ArrayList<InforUser>();
		List<Object[]> plainObj = customNativeSelectQuery(PARKING_FETCHUSER).setString("parkingid", infparking.getParkingid()).list();
		for(Object[] obj: plainObj){
			InforUser inforUser = new InforUser();
			inforUser.setUserid((Integer)obj[0]);
			inforUser.setFirstname((String)obj[1]);
			inforUser.setLastname((String)obj[2]);
			inforUser.setPosition((String)obj[3]);
			inforUser.setContactnumber((String)obj[4]);
			inforUser.setEmailaddress((String)obj[5]);
			inforUser.setInforaddress((String)obj[6]);
			iu.add(inforUser);
		}	
		return iu;
	}
}
