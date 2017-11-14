package com.sprthyme.controller;

import java.sql.SQLException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sprthyme.service.IndexService;

@Controller
public class IndexController {

	@Autowired
	private IndexService service;
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("recipient", "World");
        return "index";
    }
    
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public String indexData(Model model, @RequestParam("lang") Locale locale) throws SQLException {
        model.addAttribute("recipient", "World");
        model.addAttribute("lang", locale);
        model.addAttribute("listData", service.getAllLicense());
        return "index";
    }
    
}
