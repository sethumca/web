package com.sprthyme.controller;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.log4j.Log4j;

@Log4j
public abstract class AbstractController {
	
	protected void checkRequest(HttpServletRequest request) {
		log.info(request.getRequestURI());
		// check request origin and other validation here
	}
	
}
