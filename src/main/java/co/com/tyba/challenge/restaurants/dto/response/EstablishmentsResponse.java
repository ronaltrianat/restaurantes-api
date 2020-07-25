package co.com.tyba.challenge.restaurants.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EstablishmentsResponse {
  private List<Establishment> establishments;
}
