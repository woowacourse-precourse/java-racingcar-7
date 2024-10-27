package racingcar.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.enums.ErrorMessage;

public class CarValidator {
  private static final String regex = "[^a-zA-Z0-9]";

  public static void validateCarNumber(List<String> splittedNames) {
    if (splittedNames.size() == 1) {
      throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NUMBER.getMessage());
    }
  }

  public static void validateDuplicateCarName(List<String> splittedNames) {
    Set<String> uniqueNames = new HashSet<>();
    for (String name : splittedNames) {
      if (!uniqueNames.add(name)) {
        throw new IllegalArgumentException(ErrorMessage.INVALID_DUPLICATE_CAR_NAME.getMessage());
      }
    }
  }

  public static void validateCarName(String name) {
    if (name.trim().isEmpty()) {
      throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_EMPTY.getMessage());
    }
    if (name.length() > 5) {
      throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH.getMessage());
    }
    if (name.matches("\\d+")) {
      throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_NUMERIC_ONLY.getMessage());
    }
    if (name.matches(".*" + regex + ".*")) {
      throw new IllegalArgumentException(
          ErrorMessage.INVALID_CAR_NAME_INCLUDE_SPECIAL_CHAR.getMessage());
    }
  }
}
