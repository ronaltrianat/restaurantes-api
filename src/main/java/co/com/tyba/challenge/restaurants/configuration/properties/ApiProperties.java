package co.com.tyba.challenge.restaurants.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("api")
@Setter
@Getter
public class ApiProperties {
  private ZomatoProperties zomato;
  private DatabaseProperties database;
  private JwtProperties jwt;
}
