package com.infor.idao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import com.infor.dao.ParkingMaintananceDao;
import com.infor.dto.MaintenanceDTO;
import com.infor.models.InforParking;


@Repository
@Transactional
public class ParkingMaintenanceIDao extends HibernateDaoSupport implements ParkingMaintananceDao{
	
	private static final String PARKING_FETCHALL_HQL = "from InforParking";
	private static final String PARKING_MODIFY_HQL = "update InforParking set isparkingtandem=:isparkingtandem, userid=:userid where parkingid=:parkingid";
	private static final String PARKING_DELETE_HQL = "delete from InforParking where parkingid=:parkingid";

	

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
		Query q= getSessionFactory().createQuery(PARKING_MODIFY_HQL);
		q.setParameter("parkingid", inforParking.getParkingid());
		q.setParameter("userid", inforParking.getUserid());
		q.setParameter("isparkingtandem", inforParking.getIsparkingtandem());
		q.executeUpdate();
	}

	@Override
	public List<InforParking> selectParking(MaintenanceDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InforParking> selectAllParking() {
		return customSelectQuery(PARKING_FETCHALL_HQL)
				.list();
	}
}
