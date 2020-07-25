package co.com.tyba.challenge.restaurants.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse extends GenericResponse {
  private String token;
}
