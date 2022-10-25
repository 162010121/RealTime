package com.recipes.advice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.recipes.exception.ReciepeNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ReciepeNotFoundException.class)
	public ResponseEntity<?> reciepeNotFoundException(ReciepeNotFoundException notFound) 
	{
		Map<String, Object> errorMessage=new LinkedHashMap<>();
			
		errorMessage.put("error", "creationFailed");
		errorMessage.put("timestamp", LocalDateTime.now());
		errorMessage.put("details", notFound.getMessage());
		
		return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
				
		
	}
}
