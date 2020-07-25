package co.com.tyba.challenge.restaurants.model;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "transactions", schemaVersion = "1.0")
@Getter
@Setter
public class Transaction {
  @Id private long id;
  private String params;
  private String username;
}
