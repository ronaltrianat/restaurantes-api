package co.com.tyba.challenge.restaurants.exceptions;

public class BusinessException extends RuntimeException {

  private static final long serialVersionUID = 3177046413016226860L;

  public BusinessException(String message) {
    super(message);
  }

  public BusinessException(String message, Throwable cause) {
    super(message, cause);
  }
}
