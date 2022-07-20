package br.com.gestaoConta.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidacaoHandler {
	/*
	 * Classe de configuracao dos erros que vao ser enviados nas requisicoes
	 */
	
	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<MessageResponse> handle(MethodArgumentNotValidException exception){
		List<MessageResponse> dto = new ArrayList<>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		
		for(FieldError error : fieldErrors) {
			MessageResponse e = new MessageResponse(
					new Date(), 
					messageSource.getMessage(error, LocaleContextHolder.getLocale()),
					HttpStatus.BAD_REQUEST.value());
			
			dto.add(e);
		}
		return dto;
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public MessageResponse exception(Exception exception){
		MessageResponse dto = new MessageResponse(
				new Date(), 
				exception.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		return dto;
	}
	
	@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(IllegalArgumentException.class)
	public MessageResponse illegalArgumentException(Exception exception){
		MessageResponse dto = new MessageResponse(
				new Date(), 
				exception.getMessage(),
				HttpStatus.UNPROCESSABLE_ENTITY.value());
		
		return dto;
	}
}