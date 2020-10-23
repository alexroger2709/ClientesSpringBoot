package br.com.clientes.exception.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import br.com.clientes.exception.ApiErrors;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@RestControllerAdvice
public class ApplicationControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ApiErrors handleValidationErros( MethodArgumentNotValidException ex) {
		BindingResult bindingResult = ex.getBindingResult();
		ApiErrors ret = null;

		List<String> errorMessages = bindingResult.getAllErrors()
			.stream()	
			.map( objectError -> objectError.getDefaultMessage() )
			.collect(Collectors.toList());

		ret = new ApiErrors(errorMessages);
		return ret;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity handleValidationException( ResponseStatusException ex ) {
		String errorMessage;
		HttpStatus httpStatus;
		ApiErrors apiErrors;
		
		errorMessage = ex.getMessage();
		httpStatus = ex.getStatus();
		apiErrors = new ApiErrors(errorMessage);
		
		return new ResponseEntity(apiErrors, httpStatus);
	}
}
