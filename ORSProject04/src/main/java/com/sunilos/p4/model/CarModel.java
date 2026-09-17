package com.sunilos.p4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sunilos.p4.bean.CarBean;
import com.sunilos.p4.exception.ApplicationException;
import com.sunilos.p4.exception.DuplicateRecordException;
import com.sunilos.p4.util.JDBCDataSource;

public class CarModel extends BaseModel<CarBean>{
	
	@Override
	public CarBean getBean() {
		return new CarBean();
	}

	@Override
	public long add(CarBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		int pk = 0;
		
		CarBean existBean = findByName(bean.getName());
		
		if(existBean != null) {
			throw new DuplicateRecordException("findByName is already exist");
			
		}
		
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			
			pk = nextPK();
			System.out.println("add method is start");
			
			PreparedStatement ps = conn.prepareStatement("insert into " + getTable() + " values()");
			ps.setInt(1, pk);
			ps.setString(2, bean.getName());
			ps.setString(3, bean.getShowroom());
			ps.setString(4, bean.getLocation());
			ps.setString(5, bean.getCreatedBy());
			ps.setString(6, bean.getModifiedBy());
			ps.setTimestamp(7, bean.getCreatedDatetime());
			ps.setTimestamp(9, bean.getModifiedDatetime());
			ps.executeUpdate();
			conn.commit();
			ps.close();
			
			
		}catch (Exception e) {
			try {
				conn.rollback();
			}catch(Exception ex) {
				throw new ApplicationException("excetion in rollback" + e.getMessage());
	 			// TODO: handle exception
			}
			throw new ApplicationException("Exception is add" + e.getMessage());
			
		}finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk;
	}

	private CarBean findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CarBean bean) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getWhereClause(CarBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTable() {
		return "car";
	
	}

}
