package co.com.tyba.challenge.restaurants.service;

import co.com.tyba.challenge.restaurants.dto.response.EstablishmentsResponse;
import co.com.tyba.challenge.restaurants.dto.response.TransactionsResponse;
import org.springframework.util.MultiValueMap;

public interface IRestaurantsService {

  EstablishmentsResponse searchRestaurants(MultiValueMap<String, String> params, String username);

  TransactionsResponse findTransactions(String username);
}
