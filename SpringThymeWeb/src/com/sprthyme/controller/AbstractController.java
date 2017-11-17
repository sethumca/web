package com.sprthyme.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.sprthyme.util.PageConstant;

import lombok.extern.log4j.Log4j;

@Log4j
public abstract class AbstractController {
	
	protected void checkRequest(HttpServletRequest request) {
		log.info(request.getRequestURI());
	}
	
	protected String showError(Model model, Throwable e) {
		model.addAttribute("message", e.getLocalizedMessage());
		model.addAttribute("stacktrace", e.getStackTrace());
		return PageConstant.ERROR_HTML;
	}
	
}
