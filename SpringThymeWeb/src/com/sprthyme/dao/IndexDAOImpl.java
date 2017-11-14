package com.sprthyme.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.sprthyme.model.LicenseModel;

@Repository
public class IndexDAOImpl extends AbstractConnection implements IndexDAO {

	private static final String REMOTE_QRY = "SELECT rd.company_code, rd.serial, ld.counters, ld.lics_type, count(*) " 
			+ "activated_lics FROM license_remotedata rd, license_metadata ld WHERE rd.company_code=ld.company_code AND "
			+ "rd.serial=ld.serial GROUP BY rd.company_code, rd.serial";
	
	@Override
	public List<LicenseModel> getAllLicense() throws SQLException {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<LicenseModel> persons = dbConnection.query(REMOTE_QRY, new BeanPropertyRowMapper(LicenseModel.class));
		return persons;
	}

}
