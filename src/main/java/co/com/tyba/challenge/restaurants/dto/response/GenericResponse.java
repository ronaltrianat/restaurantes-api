package co.com.tyba.challenge.restaurants.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericResponse {
  private boolean success;
  private String message;
}
