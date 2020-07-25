package co.com.tyba.challenge.restaurants.service.implement;

import co.com.tyba.challenge.restaurants.configuration.properties.ApiMessagesProperties;
import co.com.tyba.challenge.restaurants.constants.ApiConstants;
import co.com.tyba.challenge.restaurants.dto.request.LoginRequest;
import co.com.tyba.challenge.restaurants.dto.response.LoginResponse;
import co.com.tyba.challenge.restaurants.exceptions.BusinessException;
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

  private final ApiMessagesProperties messagesProperties;
  private final IDatabaseService databaseService;
  private final JWTUtil jwtUtil;

  private static final String USER_DOES_NOT_EXIST = "user-does-not-exist";
  private static final String INVALID_CREDENTIALS = "invalid-credentials";

  public LoginService(
      ApiMessagesProperties messagesProperties, IDatabaseService databaseService, JWTUtil jwtUtil) {
    this.messagesProperties = messagesProperties;
    this.databaseService = databaseService;
    this.jwtUtil = jwtUtil;
  }

  @Override
  public LoginResponse login(LoginRequest request) {

    LoginResponse response = new LoginResponse();

    try {
      // realizar la consulta de la informacion del usuario
      UserModel userModel =
          (UserModel) this.databaseService.findById(request.getUsername(), UserModel.class);

      // realizar las validaciones de negocio
      validateUserModel(request, userModel);

      // generar respuesta
      response.setSuccess(true);
      response.setToken(jwtUtil.getJWTToken(request.getUsername()));
    } catch (BusinessException be) {
      log.error("BusinessException", be);
      response.setMessage(be.getMessage());
    } catch (Exception e) {
      log.error("Exception", e);
      response.setMessage(messagesProperties.getLogin().get(ApiConstants.DEFAULT_MESSAGE));
    }

    return response;
  }

  private void validateUserModel(LoginRequest request, UserModel userModel) {
    if (Objects.isNull(userModel)) {
      throw new BusinessException(messagesProperties.getLogin().get(USER_DOES_NOT_EXIST));
    }
    if (!request.getPassword().equals(userModel.getPassword())) {
      throw new BusinessException(messagesProperties.getLogin().get(INVALID_CREDENTIALS));
    }
  }
}
