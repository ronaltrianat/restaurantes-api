package co.com.tyba.challenge.restaurants.configuration.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtProperties {
  private String id;
  private String secretKey;
  private long expirationMillis;
}
