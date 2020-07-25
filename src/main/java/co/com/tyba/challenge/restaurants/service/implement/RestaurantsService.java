package co.com.tyba.challenge.restaurants.service.implement;

import co.com.tyba.challenge.restaurants.configuration.properties.ApiMessagesProperties;
import co.com.tyba.challenge.restaurants.constants.ApiConstants;
import co.com.tyba.challenge.restaurants.dto.response.EstablishmentsResponse;
import co.com.tyba.challenge.restaurants.dto.response.TransactionsResponse;
import co.com.tyba.challenge.restaurants.model.Transaction;
import co.com.tyba.challenge.restaurants.service.IDatabaseService;
import co.com.tyba.challenge.restaurants.service.IRestaurantsService;
import co.com.tyba.challenge.restaurants.service.IZomatoService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@Service
public class RestaurantsService implements IRestaurantsService {

  private final IZomatoService zomatoService;
  private final IDatabaseService databaseService;
  private final ApiMessagesProperties messagesProperties;

  private static final String SEARCH_PARAMETERS_ARE_INVALID = "search-parameters-are-invalid";

  public RestaurantsService(
      IZomatoService zomatoService,
      IDatabaseService databaseService,
      ApiMessagesProperties messagesProperties) {
    this.zomatoService = zomatoService;
    this.databaseService = databaseService;
    this.messagesProperties = messagesProperties;
  }

  @Override
  public EstablishmentsResponse searchRestaurants(
      MultiValueMap<String, String> params, String username) {
    EstablishmentsResponse response = new EstablishmentsResponse();
    try {
      saveTransaccion(params, username);
      response = this.zomatoService.searchRestaurants(params);
      response.setSuccess(true);
    } catch (HttpClientErrorException hce) {
      log.error("searchRestaurants:HttpClientErrorException", hce);
      response.setMessage(
          this.messagesProperties.getRestaurants().get(SEARCH_PARAMETERS_ARE_INVALID));
    } catch (Exception e) {
      log.error("searchRestaurants:Exception", e);
      response.setMessage(
          this.messagesProperties.getRestaurants().get(ApiConstants.DEFAULT_MESSAGE));
    }
    return response;
  }

  @Override
  public TransactionsResponse findTransactions(String username) {
    List<Transaction> transactions = this.databaseService.findTransactions(username);
    TransactionsResponse response = new TransactionsResponse();
    response.setTransactions(transactions);
    response.setSuccess(true);
    return response;
  }

  private void saveTransaccion(MultiValueMap<String, String> params, String username) {
    Transaction transaction = new Transaction();
    transaction.setId(System.currentTimeMillis());
    transaction.setParams(params.toString());
    transaction.setUsername(username);
    databaseService.save(transaction);
  }
}
