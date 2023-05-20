package com.pack.exceptions;

import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.pack.entity.Response;

@ControllerAdvice
public class ExceptionHandler {
	
	
	private static final Logger log = LoggerFactory.getLogger(ExceptionHandler.class);

	
	@org.springframework.web.bind.annotation.ExceptionHandler({RuntimeException.class})
	public ResponseEntity<Response> exceptionHandler(RuntimeException ex)
	{
		log.error(ex.getMessage());
		return new ResponseEntity<>(
				new Response(
						HttpStatus.BAD_REQUEST.value(),
						ex.getMessage()),
				HttpStatus.BAD_REQUEST);
	}
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler({FileNotFoundException.class})
	public ResponseEntity<Response> exceptionHandler(FileNotFoundException ex)
	{
		log.error(ex.getMessage());
		return new ResponseEntity<>(
				new Response(
						HttpStatus.BAD_REQUEST.value(),
						ex.getMessage()),
				HttpStatus.BAD_REQUEST);
	}
}
