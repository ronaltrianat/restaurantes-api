package co.com.tyba.challenge.restaurants.service;

import co.com.tyba.challenge.restaurants.model.Transaction;
import java.util.List;

public interface IDatabaseService {

  void save(Object model);

  Object findById(Object id, Class classCollection);

  List<Transaction> findTransactions(String username);
}
