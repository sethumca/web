package com.sprthyme.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprthyme.dao.IndexDAO;
import com.sprthyme.model.LicenseModel;

@Service
public class IndexServiceImpl implements IndexService {
	
	@Autowired
	private IndexDAO dao;

	@Override
	public List<LicenseModel> getAllLicense() throws SQLException {
		return dao.getAllLicense();
	}

}
