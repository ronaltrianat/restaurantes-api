package co.com.tyba.challenge.restaurants.controller;

import co.com.tyba.challenge.restaurants.dto.request.LoginRequest;
import co.com.tyba.challenge.restaurants.dto.response.LoginResponse;
import co.com.tyba.challenge.restaurants.service.ILoginService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

  private final ILoginService loginService;

  public AuthController(ILoginService loginService) {
    this.loginService = loginService;
  }

  @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
    return ResponseEntity.ok(loginService.login(request));
  }
}
