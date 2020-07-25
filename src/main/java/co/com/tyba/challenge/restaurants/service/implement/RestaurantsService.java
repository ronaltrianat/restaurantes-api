package co.com.tyba.challenge.restaurants.service.implement;

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

@Slf4j
@Service
public class RestaurantsService implements IRestaurantsService {

  private final IZomatoService zomatoService;
  private final IDatabaseService databaseService;

  public RestaurantsService(IZomatoService zomatoService, IDatabaseService databaseService) {
    this.zomatoService = zomatoService;
    this.databaseService = databaseService;
  }

  @Override
  public EstablishmentsResponse searchRestaurants(
      MultiValueMap<String, String> params, String username) {
    saveTransaccion(params, username);
    return this.zomatoService.searchRestaurants(params);
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
