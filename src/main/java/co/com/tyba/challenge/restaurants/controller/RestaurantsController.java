package co.com.tyba.challenge.restaurants.controller;

import co.com.tyba.challenge.restaurants.dto.response.EstablishmentsResponse;
import co.com.tyba.challenge.restaurants.dto.response.TransactionsResponse;
import co.com.tyba.challenge.restaurants.service.IRestaurantsService;
import java.security.Principal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantsController {

  private final IRestaurantsService restaurantsService;

  public RestaurantsController(IRestaurantsService restaurantsService) {
    this.restaurantsService = restaurantsService;
  }

  @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<EstablishmentsResponse> searchRestaurants(
      @RequestParam MultiValueMap<String, String> params, Principal principal) {
    return ResponseEntity.ok(restaurantsService.searchRestaurants(params, principal.getName()));
  }

  @GetMapping(value = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TransactionsResponse> findTransactions(Principal principal) {
    return ResponseEntity.ok(restaurantsService.findTransactions(principal.getName()));
  }

}
