package com.sprthyme.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalControllerAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> getSQLError(Exception exception) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("HeaderKey", "HeaderDetails");
		return new ResponseEntity<>("Rest Controller Advice Example", headers, HttpStatus.ACCEPTED);
	}

}
