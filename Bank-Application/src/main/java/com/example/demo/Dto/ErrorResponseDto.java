package com.example.demo.Dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ErrorResponseDto {
	
	private String apiPath;
	private HttpStatus errorcode;
	private String errorMsg;
	private LocalDateTime errorTime;

}
