package com.sprthyme.controller;

import java.sql.SQLException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sprthyme.service.IndexService;
import com.sprthyme.util.PageConstant;

@Controller
public class IndexController extends AbstractController {

	@Autowired
	private IndexService service;
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(HttpServletRequest request, Model model) {
    	checkRequest(request);
        return PageConstant.HOME_HTML;
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {
    	checkRequest(request);
        model.addAttribute("recipient", "World");
        return PageConstant.INDEX_HTML;
    }
    
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public String indexDefault(HttpServletRequest request, Model model) throws SQLException {
    	checkRequest(request);
		model.addAttribute("listData", service.getAllLicense());
		return PageConstant.INDEX_HTML;
    }
    
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    public String indexData(HttpServletRequest request, Model model, @RequestParam("lang") Locale locale) throws SQLException {
    	checkRequest(request);
		model.addAttribute("lang", locale);
		model.addAttribute("listData", service.getAllLicense());
		return PageConstant.INDEX_HTML;
    }
    
}
