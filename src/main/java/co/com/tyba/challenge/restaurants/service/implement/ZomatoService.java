package co.com.tyba.challenge.restaurants.service.implement;

import co.com.tyba.challenge.restaurants.configuration.properties.ApiProperties;
import co.com.tyba.challenge.restaurants.dto.response.EstablishmentsResponse;
import co.com.tyba.challenge.restaurants.service.IZomatoService;
import java.util.Collections;
import java.util.Objects;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ZomatoService implements IZomatoService {

  private final RestTemplate restTemplate;
  private final ApiProperties apiProperties;

  public ZomatoService(RestTemplate restTemplate, ApiProperties apiProperties) {
    this.restTemplate = restTemplate;
    this.apiProperties = apiProperties;
  }

  @Override
  public EstablishmentsResponse searchRestaurants(MultiValueMap<String, String> queryParams) {

    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    headers.set(apiProperties.getApiKeyName(), apiProperties.getApiKeyValue());
    HttpEntity request = new HttpEntity(headers);

    UriComponents builder =
        UriComponentsBuilder.fromHttpUrl(apiProperties.getZomatoUriEstablishments())
            .queryParams(queryParams)
            .build();

    ResponseEntity<EstablishmentsResponse> response =
        restTemplate.exchange(
            builder.toUriString(), HttpMethod.GET, request, EstablishmentsResponse.class);

    return (Objects.nonNull(response) && HttpStatus.OK.equals(response.getStatusCode()))
        ? response.getBody()
        : null;
  }
}
