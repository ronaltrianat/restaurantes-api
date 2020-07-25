package co.com.tyba.challenge.restaurants.configuration;

import co.com.tyba.challenge.restaurants.configuration.properties.ApiProperties;
import io.jsondb.JsonDBTemplate;
import io.jsondb.crypto.Default1Cipher;
import io.jsondb.crypto.ICipher;
import java.security.GeneralSecurityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanProvider {

  @Autowired private ApiProperties apiProperties;

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }

  @Bean
  public JsonDBTemplate jsonDBTemplate() throws GeneralSecurityException {
    final String baseScanPackage = "co.com.tyba.challenge.restaurants.model";
    ICipher cipher = new Default1Cipher(apiProperties.getDatabase().getKeyCipher());
    return new JsonDBTemplate(
        apiProperties.getDatabase().getFilesLocation(), baseScanPackage, cipher);
  }
}
