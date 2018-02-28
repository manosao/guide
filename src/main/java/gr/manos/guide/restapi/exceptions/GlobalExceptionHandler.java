package gr.manos.guide.restapi.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
//	@ExceptionHandler(OpapCodeNotificationException.class)
//	public ResponseEntity<String> genericExceptionHandler(OpapCodeNotificationException ex, WebRequest request) {
//		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> genericExceptionHandler(Exception ex, WebRequest request) {
		log.error("Unknown error: {}", ex);
		return new ResponseEntity<String>("Unknown error:" + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
