package co.com.tyba.challenge.restaurants.security;

import co.com.tyba.challenge.restaurants.configuration.properties.ApiProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

  private final ApiProperties apiProperties;

  public JWTAuthorizationFilter(ApiProperties apiProperties) {
    this.apiProperties = apiProperties;
  }

  private final String HEADER = "Authorization";
  private final String PREFIX = "Bearer ";

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws ServletException, IOException {
    try {
      if (validateTokenJWT(request, response)) {
        Claims claims = validateToken(request);
        if (claims.get("authorities") != null) {
          setUpSpringAuthentication(claims);
        } else {
          SecurityContextHolder.clearContext();
        }
      } else {
        SecurityContextHolder.clearContext();
      }
      chain.doFilter(request, response);
    } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
      response.setStatus(HttpServletResponse.SC_FORBIDDEN);
      response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
      return;
    }
  }

  private Claims validateToken(HttpServletRequest request) {
    String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
    return Jwts.parser()
        .setSigningKey(this.apiProperties.getJwtSecretKey().getBytes())
        .parseClaimsJws(jwtToken)
        .getBody();
  }

  private void setUpSpringAuthentication(Claims claims) {
    @SuppressWarnings("unchecked")
    List<String> authorities = (List) claims.get("authorities");

    UsernamePasswordAuthenticationToken auth =
        new UsernamePasswordAuthenticationToken(
            claims.getSubject(),
            null,
            authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    SecurityContextHolder.getContext().setAuthentication(auth);
  }

  private boolean validateTokenJWT(HttpServletRequest request, HttpServletResponse res) {
    String authenticationHeader = request.getHeader(HEADER);
    if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX)) return false;
    return true;
  }
}
