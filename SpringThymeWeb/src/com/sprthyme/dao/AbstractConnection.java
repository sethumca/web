package com.sprthyme.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractConnection {
	
	@Autowired
	protected JdbcTemplate dbConnection;

}
