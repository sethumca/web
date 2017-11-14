package com.sprthyme.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sprthyme.model.LicenseList;
import com.sprthyme.service.IndexService;

@Controller
public class IndexController {

	@Autowired
	private IndexService service;
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("recipient", "World");
        return "index.html";
    }
    
    @RequestMapping(value = "/lics", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody LicenseList getAllLicsJson(Model model) throws SQLException {
    	LicenseList list = new LicenseList();
    	list.setLicenses(service.getAllLicense());
    	return list;
    }
    
    @RequestMapping(value = "/licsxml", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody LicenseList getAllLicsXml(Model model) throws SQLException {
    	LicenseList list = new LicenseList();
    	list.setLicenses(service.getAllLicense());
    	return list;
    }
    
}
