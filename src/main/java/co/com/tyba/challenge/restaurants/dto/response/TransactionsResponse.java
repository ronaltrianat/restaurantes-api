package co.com.tyba.challenge.restaurants.dto.response;

import co.com.tyba.challenge.restaurants.model.Transaction;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionsResponse extends GenericResponse {
  private List<Transaction> transactions;
}
