package co.com.tyba.challenge.restaurants.model;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;
import io.jsondb.annotation.Secret;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Document(collection = "users", schemaVersion = "1.0")
@Getter
@Setter
@Builder
public class UserModel {
  @Id private String username;
  @Secret private String password;
}
