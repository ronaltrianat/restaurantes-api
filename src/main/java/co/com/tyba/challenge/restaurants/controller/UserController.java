package co.com.tyba.challenge.restaurants.controller;

import co.com.tyba.challenge.restaurants.dto.request.UserRegisterRequest;
import co.com.tyba.challenge.restaurants.dto.response.GenericResponse;
import co.com.tyba.challenge.restaurants.service.IUserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

  private final IUserService userService;

  public UserController(IUserService userService) {
    this.userService = userService;
  }

  @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<GenericResponse> registerUser(@RequestBody UserRegisterRequest request) {
    return ResponseEntity.ok(userService.registerUser(request));
  }
}
