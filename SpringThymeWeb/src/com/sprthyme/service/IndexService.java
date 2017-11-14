package com.sprthyme.service;

import java.sql.SQLException;
import java.util.List;

import com.sprthyme.model.LicenseModel;

public interface IndexService {
	
	public List<LicenseModel> getAllLicense() throws SQLException;

}
