package com.example.demo.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.Dto.ErrorResponseDto;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(CustomerAlreadyExists.class)
	public ResponseEntity<ErrorResponseDto> handlecustomException1(CustomerAlreadyExists exc
			,WebRequest webrequest){
		
		ErrorResponseDto errorResponseDto = new ErrorResponseDto(
				webrequest.getDescription(false)
				,HttpStatus.BAD_GATEWAY
				,exc.getMessage()
				,LocalDateTime.now()
				);
		
		return new ResponseEntity<>(errorResponseDto,HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(ResourseNotFound.class)
	public ResponseEntity<ErrorResponseDto> handlecustomException2(ResourseNotFound exc
			,WebRequest webrequest){
		
		ErrorResponseDto errorResponseDto = new ErrorResponseDto(
				webrequest.getDescription(false)
				,HttpStatus.NOT_FOUND
				,exc.getMessage()
				,LocalDateTime.now()
				);
		
		return new ResponseEntity<>(errorResponseDto,HttpStatus.NOT_FOUND);
	}
	

}
