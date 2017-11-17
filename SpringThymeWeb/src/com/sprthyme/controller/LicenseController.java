package com.sprthyme.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprthyme.model.LicenseList;
import com.sprthyme.service.IndexService;

@RestController
public class LicenseController extends AbstractController {
	
	@Autowired
	private IndexService service;
	
	@RequestMapping(value = "/lics", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody LicenseList getAllLicsJson(HttpServletRequest request, Model model) throws SQLException {
		checkRequest(request);
    	LicenseList list = new LicenseList();
    	list.setLicenses(service.getAllLicense());
    	return list;
    }
    
    @RequestMapping(value = "/licsxml", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody LicenseList getAllLicsXml(HttpServletRequest request, Model model) throws SQLException {
    	checkRequest(request);
    	LicenseList list = new LicenseList();
    	list.setLicenses(service.getAllLicense());
    	return list;
    }
    
}
