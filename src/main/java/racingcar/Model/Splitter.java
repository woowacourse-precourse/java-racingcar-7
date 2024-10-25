package racingcar.Model;

import java.util.List;

public class Splitter {
  private static final String CAR_NAME_DELIMITER = ",";

  public static List<String> splitNames(String carNames) {
    List<String> members = List.of(carNames.split(CAR_NAME_DELIMITER));
    return members;
  }
}
