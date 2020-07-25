package co.com.tyba.challenge.restaurants.service;

import co.com.tyba.challenge.restaurants.dto.request.UserRegisterRequest;
import co.com.tyba.challenge.restaurants.dto.response.GenericResponse;

public interface IUserService {

  GenericResponse registerUser(UserRegisterRequest request);
}
