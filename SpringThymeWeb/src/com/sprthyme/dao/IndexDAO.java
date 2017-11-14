package com.sprthyme.dao;

import java.sql.SQLException;
import java.util.List;

import com.sprthyme.model.LicenseModel;

public interface IndexDAO {
	
	public List<LicenseModel> getAllLicense() throws SQLException;

}
