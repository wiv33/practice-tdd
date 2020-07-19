package org.psawesome.tdd.chap07.testDouble;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author ps [https://github.com/wiv33/practice-tdd]
 * @role
 * @responsibility
 * @cooperate {
 * input:
 * output:
 * }
 * @see
 * @since 20. 7. 19. Sunday
 */
public class CardNumberValidator {
  public CardValidity validate(String cardNumber) {
    final HttpClient httpClient = HttpClient.newHttpClient();
    final HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://example-psawesome.org/card"))
            .header("Content-Type", "text/plain")
            .POST(HttpRequest.BodyPublishers.ofString(cardNumber))
            .build();
    try {
      final HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
      switch (response.body()) {
        case "ok":
          return CardValidity.VALID;
        case "bad":
          return CardValidity.INVALID;
        case "expired":
          return CardValidity.EXPIRED;
        case "theft":
          return CardValidity.THEFT;
        default:
          return CardValidity.UNKNOWN;
      }
    } catch (IOException | InterruptedException e) {
      return CardValidity.ERROR;
    }
  }
}
