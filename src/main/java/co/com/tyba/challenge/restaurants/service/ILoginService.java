package co.com.tyba.challenge.restaurants.service;

import co.com.tyba.challenge.restaurants.dto.request.LoginRequest;
import co.com.tyba.challenge.restaurants.dto.response.LoginResponse;

public interface ILoginService {

  LoginResponse login(LoginRequest request);
}
