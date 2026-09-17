package com.sunilos.p4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarBean extends BaseBean {
	
	private String name;
	private String showroom;
	private String location;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShowroom() {
		return showroom;
	}

	public void setShowroom(String showroom) {
		this.showroom = showroom;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id + "";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "name";
	}
	
	@Override
	public void setResultset(ResultSet rs) {
		super.setResultset(rs);
		CarBean bean = new CarBean();
		try {
			bean.setId(rs.getLong("id"));
			bean.setName(rs.getString("name"));
			bean.setShowroom(rs.getString("showroom"));
			bean.setLocation(rs.getString("location"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
