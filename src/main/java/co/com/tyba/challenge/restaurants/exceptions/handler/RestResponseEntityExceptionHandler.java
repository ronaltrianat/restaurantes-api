package co.com.tyba.challenge.restaurants.exceptions.handler;

import co.com.tyba.challenge.restaurants.configuration.properties.ApiMessagesProperties;
import co.com.tyba.challenge.restaurants.dto.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @Autowired private ApiMessagesProperties messagesProperties;

  @ExceptionHandler(value = {Exception.class})
  protected ResponseEntity<GenericResponse> handleConflict(RuntimeException ex) {
    GenericResponse response = new GenericResponse();
    response.setMessage(messagesProperties.getDefaultError());
    return ResponseEntity.ok(response);
  }
}
