package co.com.tyba.challenge.restaurants.service;

import co.com.tyba.challenge.restaurants.dto.response.EstablishmentsResponse;
import org.springframework.util.MultiValueMap;

public interface IZomatoService {
  EstablishmentsResponse searchRestaurants(MultiValueMap<String, String> queryParams);
}
