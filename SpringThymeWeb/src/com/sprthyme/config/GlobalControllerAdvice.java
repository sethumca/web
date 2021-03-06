package com.sprthyme.config;

import java.sql.SQLException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.sprthyme.util.PageConstant;

import lombok.extern.log4j.Log4j;

@Log4j
@ControllerAdvice
public class GlobalControllerAdvice {

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleResourceNotFoundException(Exception e) {
		return PageConstant.NOT_FOUND;
	}
	
	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException(Exception e, Model model) {
		log.error("A Null Pointer Exception Ocurred ", e);
		model.addAttribute("message", e.getLocalizedMessage());
		model.addAttribute("stacktrace", e.getStackTrace());
		return PageConstant.ERROR_HTML;
	}
	
	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleAllException(Exception e, Model model) {
		log.error("An Unknow Exception Ocurred: ", e);
		model.addAttribute("message", e.getLocalizedMessage());
		model.addAttribute("stacktrace", e.getStackTrace());
		return PageConstant.ERROR_HTML;
	}

	@ExceptionHandler(SQLException.class)
	public ResponseEntity<String> getSQLError(Exception e) {
		log.error("An Exception Ocurred: ", e);
		HttpHeaders headers = new HttpHeaders();
		headers.set("HeaderKey", "HeaderDetails");
		return new ResponseEntity<>("Rest Controller Advice Example", headers, HttpStatus.ACCEPTED);
	}

}
