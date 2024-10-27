package racingcar.error;

import java.util.HashSet;
import java.util.Set;

public class CarsValidator {

  private CarsValidator() {
  }

  public static void validateCarNamesInput(String carNamesInput) {
    if (isNullOrEmpty(carNamesInput)) {
      throw new IllegalArgumentException(ErrorMessages.INPUT_EMPTY.getMessage());
    }
  }

  private static boolean isNullOrEmpty(String input) {
    return input == null || input.trim().isEmpty();
  }

  public static void validateCarNames(String[] carNames) {
    checkEmptyNames(carNames);
    checkDuplicateNames(carNames);
  }

  private static void checkEmptyNames(String[] carNames) {
    for (String name : carNames) {
      validateNameIsNotEmpty(name);
    }
  }

  private static void validateNameIsNotEmpty(String name) {
    if (isEmptyName(name)) {
      throw new IllegalArgumentException(ErrorMessages.CAR_NAME_EMPTY.getMessage());
    }
  }

  private static boolean isEmptyName(String name) {
    return name == null || name.trim().isEmpty();
  }

  private static void checkDuplicateNames(String[] carNames) {
    Set<String> uniqueNames = new HashSet<>();
    for (String name : carNames) {
      addUniqueName(uniqueNames, name.trim());
    }
  }

  private static void addUniqueName(Set<String> uniqueNames, String name) {
    if (!uniqueNames.add(name)) {
      throw new IllegalArgumentException(ErrorMessages.CAR_NAME_DUPLICATE.getMessage());
    }
  }
}
