package co.com.tyba.challenge.restaurants.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EstablishmentsResponse extends GenericResponse {
  private List<Establishment> establishments;
}
