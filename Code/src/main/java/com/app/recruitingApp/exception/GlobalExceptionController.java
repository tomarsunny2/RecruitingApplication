package com.app.recruitingApp.exception;

import com.app.recruitingApp.model.ErrorBean;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
* Global Exception class will handle all exception thrown by application. 
* To DO : handle all type of exceptions
*/

@ControllerAdvice
public class GlobalExceptionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionController.class);

	@ExceptionHandler(value=DataIntegrityViolationException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorBean handleResourceAccessException(HttpServletResponse httpResponse, DataIntegrityViolationException exp){
		LOGGER.error("Error occurred: {}",exp.getMessage(),exp);
		ErrorBean errorBean = new ErrorBean();
                errorBean.setErrorCode("BAD_REQUEST");
		errorBean.setUserMessage("Data Integraty Viloation");
		httpResponse.setContentType("application/json");
		return errorBean;
	}
        
        @ExceptionHandler(value=OfferNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorBean handleOfferNotFoundException(HttpServletResponse httpResponse, OfferNotFoundException exp){
		LOGGER.error("Error occurred: {}",exp.getMessage(),exp);
		ErrorBean errorBean = new ErrorBean();
                errorBean.setErrorCode("NOT_FOUND");
		errorBean.setUserMessage(exp.getMessage());
		httpResponse.setContentType("application/json");
		return errorBean;
	}
        @ExceptionHandler(value=ApplicationNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorBean handleApplicationNotFoundException(HttpServletResponse httpResponse, ApplicationNotFoundException exp){
		LOGGER.error("Error occurred: {}",exp.getMessage(),exp);
		ErrorBean errorBean = new ErrorBean();
                errorBean.setErrorCode("NOT_FOUND");
		errorBean.setUserMessage(exp.getMessage());
		httpResponse.setContentType("application/json");
		return errorBean;
	}
        
        @ExceptionHandler(value=Exception.class)
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ErrorBean handleResourceAccessException(HttpServletResponse httpResponse, Exception exp){
		LOGGER.error("Error occurred: {}",exp.getMessage(),exp);
		final ErrorBean errorBean = new ErrorBean();
                errorBean.setErrorCode("INTERNAL_SERVER_ERROR");
		errorBean.setUserMessage("Error while performing user operation");
		httpResponse.setContentType("application/json");
		return errorBean;
	}

  
}
