package co.com.tyba.challenge.restaurants.configuration.properties;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("api.messages")
@Getter
@Setter
public class ApiMessagesProperties {

  protected static final String DEFAULT = "default";
  private String defaultError;
  private Map<String, String> login;
  private Map<String, String> restaurants;
  private Map<String, String> user;

}
