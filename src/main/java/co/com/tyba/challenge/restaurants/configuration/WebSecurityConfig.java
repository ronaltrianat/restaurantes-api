package co.com.tyba.challenge.restaurants.configuration;

import co.com.tyba.challenge.restaurants.configuration.properties.ApiProperties;
import co.com.tyba.challenge.restaurants.security.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired private ApiProperties apiProperties;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf()
        .disable()
        .addFilterAfter(new JWTAuthorizationFilter(this.apiProperties), UsernamePasswordAuthenticationFilter.class)
        .authorizeRequests()
        .antMatchers(HttpMethod.POST, "/auth/login")
        .permitAll()
        .anyRequest()
        .authenticated();
  }
}
