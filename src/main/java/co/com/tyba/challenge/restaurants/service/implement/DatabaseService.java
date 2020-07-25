package co.com.tyba.challenge.restaurants.service.implement;

import co.com.tyba.challenge.restaurants.model.Transaction;
import co.com.tyba.challenge.restaurants.model.UserModel;
import co.com.tyba.challenge.restaurants.service.IDatabaseService;
import io.jsondb.JsonDBTemplate;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService implements IDatabaseService {

  private final JsonDBTemplate jsonDBTemplate;

  public DatabaseService(JsonDBTemplate jsonDBTemplate) {
    this.jsonDBTemplate = jsonDBTemplate;
  }

  @PostConstruct
  public void setup() {
    if (!jsonDBTemplate.collectionExists(Transaction.class)) {
      jsonDBTemplate.createCollection(Transaction.class);
    }
    if (!jsonDBTemplate.collectionExists(UserModel.class)) {
      jsonDBTemplate.createCollection(UserModel.class);
    }
  }

  @Override
  public void save(Object model) {
    jsonDBTemplate.insert(model);
  }

  @Override
  public Object findById(Object id, Class classCollection) {
    return jsonDBTemplate.findById(id, classCollection);
  }

  @Override
  public List<Transaction> findTransactions(String username) {
    final String jxQuery = String.format("/.[username='%s']", username);
    return jsonDBTemplate.find(jxQuery, Transaction.class);
  }
}
