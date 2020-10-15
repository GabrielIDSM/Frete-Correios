package br.com.gabrielidsm.correios.Handler;

import br.com.gabrielidsm.correios.Error.ResourceNotFoundDetails;
import br.com.gabrielidsm.correios.Error.ResourceNotFoundException;
import br.com.gabrielidsm.correios.Error.ValidationErrorDetails;
import java.util.Date;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice //Permite usar os recursos das camadas do SB
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rfnException){
        ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails
                .builder()
                .title("Erro tratado")
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .detail(rfnException.getMessage())
                .developerMessage(rfnException.getClass().getName())
                .build();
        return new ResponseEntity(rnfDetails, HttpStatus.NOT_FOUND);        
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ValidationErrorDetails mnvDetails = ValidationErrorDetails
                .builder()
                .title("Erro tratado")
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .detail("Argument Not Valid")
                .developerMessage(ex.getClass().getName())
                .build();
        return new ResponseEntity(mnvDetails, HttpStatus.BAD_REQUEST);        
    }
}
