package co.com.tyba.challenge.restaurants.security;

import co.com.tyba.challenge.restaurants.configuration.properties.ApiProperties;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

@Component
public class JWTUtil {

  private final ApiProperties apiProperties;

  private final String PREFIX = "Bearer ";

  public JWTUtil(ApiProperties apiProperties) {
    this.apiProperties = apiProperties;
  }

  public String getJWTToken(String username) {
    List<GrantedAuthority> grantedAuthorities =
        AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

    String token =
        Jwts.builder()
            .setId(this.apiProperties.getJwtId())
            .setSubject(username)
            .claim(
                "authorities",
                grantedAuthorities.stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList()))
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(
                new Date(System.currentTimeMillis() + this.apiProperties.getJwtExpirationMillis()))
            .signWith(SignatureAlgorithm.HS512, this.apiProperties.getJwtSecretKey().getBytes())
            .compact();

    return PREFIX + token;
  }
}
