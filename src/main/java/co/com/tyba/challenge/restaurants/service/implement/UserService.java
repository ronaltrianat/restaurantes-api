package co.com.tyba.challenge.restaurants.service.implement;

import co.com.tyba.challenge.restaurants.configuration.properties.ApiMessagesProperties;
import co.com.tyba.challenge.restaurants.constants.ApiConstants;
import co.com.tyba.challenge.restaurants.dto.request.UserRegisterRequest;
import co.com.tyba.challenge.restaurants.dto.response.GenericResponse;
import co.com.tyba.challenge.restaurants.model.UserModel;
import co.com.tyba.challenge.restaurants.service.IDatabaseService;
import co.com.tyba.challenge.restaurants.service.IUserService;
import io.jsondb.InvalidJsonDbApiUsageException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService implements IUserService {

  private final IDatabaseService databaseService;
  private final ApiMessagesProperties messagesProperties;

  private static final String OBJECT_ALREADY_PRESENT = "Object already present in Collection.";
  private static final String USER_ALREADY_EXISTS = "user-already-exists";
  private static final String USER_SUCCESSFULLY_REGISTERED = "user-successfully-registered";

  public UserService(IDatabaseService databaseService, ApiMessagesProperties messagesProperties) {
    this.databaseService = databaseService;
    this.messagesProperties = messagesProperties;
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
      response.setMessage(messagesProperties.getUser().get(USER_SUCCESSFULLY_REGISTERED));
    } catch (InvalidJsonDbApiUsageException ie) {
      log.error("InvalidJsonDbApiUsageException", ie);
      if (ie.getMessage().startsWith(OBJECT_ALREADY_PRESENT)) {
        response.setMessage(messagesProperties.getUser().get(USER_ALREADY_EXISTS));
      } else {
        response.setMessage(messagesProperties.getUser().get(ApiConstants.DEFAULT_MESSAGE));
      }
    } catch (Exception e) {
      log.error("Exception", e);
      response.setMessage(messagesProperties.getUser().get(ApiConstants.DEFAULT_MESSAGE));
    }
    return response;
  }
}
