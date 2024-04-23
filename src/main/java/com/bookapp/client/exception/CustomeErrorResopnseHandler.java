package com.bookapp.client.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResponseErrorHandler;

public class CustomeErrorResopnseHandler implements ResponseErrorHandler {

	/*
	 * HttpClientErrorException – in the case of HTTP status 4xx
       HttpServerErrorException – in the case of HTTP status 5xx
       UnknownHttpStatusCodeException – in the case of an unknown HTTP status    
	 */
	
	
	
	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		
		return (response.getStatusCode().is5xxServerError()|| response.getStatusCode().is4xxClientError()|| response.getStatusCode().isError());
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		
		 
		
		  if(response.getStatusCode().is5xxServerError() ) {
			  
			  System.out.println("P");
			  throw new HttpServerErrorException(response.getStatusCode());
			  
		  }else if(response.getStatusCode().is4xxClientError()) {
			  
			  
			   if(response.getStatusCode()==HttpStatus.NOT_FOUND) {
				   throw new  BookNotFoundException("Error");
			   }
		  }
		
		
	}

	
}
