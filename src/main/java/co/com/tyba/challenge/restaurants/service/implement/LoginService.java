package co.com.tyba.challenge.restaurants.service.implement;

import co.com.tyba.challenge.restaurants.dto.request.LoginRequest;
import co.com.tyba.challenge.restaurants.dto.response.LoginResponse;
import co.com.tyba.challenge.restaurants.model.UserModel;
import co.com.tyba.challenge.restaurants.security.JWTUtil;
import co.com.tyba.challenge.restaurants.service.IDatabaseService;
import co.com.tyba.challenge.restaurants.service.ILoginService;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginService implements ILoginService {

  private final IDatabaseService databaseService;
  private final JWTUtil jwtUtil;

  public LoginService(IDatabaseService databaseService, JWTUtil jwtUtil) {
    this.databaseService = databaseService;
    this.jwtUtil = jwtUtil;
  }

  @Override
  public LoginResponse login(LoginRequest request) {
    UserModel userModel =
        (UserModel) this.databaseService.findById(request.getUsername(), UserModel.class);

    LoginResponse user = new LoginResponse();

    if (Objects.nonNull(userModel)) {
      String token = jwtUtil.getJWTToken(request.getUsername());
      user.setSuccess(true);
      user.setUsername(request.getUsername());
      user.setToken(token);
    } else {
      user.setMessage("Usuario no existe");
    }

    return user;
  }
}
