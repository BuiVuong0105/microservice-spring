package vn.com.vuong.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import vn.com.vuong.exception.DataFailException;
import vn.com.vuong.exception.Error;

@ControllerAdvice
public class AddviceController {
	 @ExceptionHandler(DataFailException.class)
	  public ResponseEntity<Error> dataConflict(DataFailException exception) {
		 return new ResponseEntity<Error>(new Error(exception.getCode(), exception.getMessage()), HttpStatus.BAD_REQUEST);
	  }
}
