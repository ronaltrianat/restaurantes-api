package co.com.tyba.challenge.restaurants.service.implement;

import co.com.tyba.challenge.restaurants.dto.request.UserRegisterRequest;
import co.com.tyba.challenge.restaurants.dto.response.GenericResponse;
import co.com.tyba.challenge.restaurants.model.UserModel;
import co.com.tyba.challenge.restaurants.service.IDatabaseService;
import co.com.tyba.challenge.restaurants.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

  private final IDatabaseService databaseService;

  public UserService(IDatabaseService databaseService) {
    this.databaseService = databaseService;
  }

  @Override
  public GenericResponse registerUser(UserRegisterRequest request) {
    GenericResponse response = new GenericResponse();
    try {
      databaseService.save(
          UserModel.builder()
              .username(request.getUsername())
              .password(request.getPassword())
              .build());
      response.setSuccess(true);
      response.setMessage("Usuario registrado satisfactoriamente.");
    } catch (Exception e) {
      response.setMessage(e.getMessage());
    }
    return response;
  }
}
