package co.com.tyba.challenge.restaurants.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequest {
  private String username;
  private String password;
}
