package racingcar.application.view.validation;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class InputValidation {

  private static final String EMPTY_INPUT_ERROR = "자동차 이름은 비어있을 수 없습니다.";
  private static final String INVALID_CAR_NAME_LENGTH_ERROR = "자동차 이름은 1자 이상, 5자 이하로 입력해야 합니다.";
  private static final String INVALID_ATTEMPT_COUNT_ERROR = "시도할 횟수는 0 이상의 숫자로 입력해 주세요.";
  private static final String DUPLICATE_CAR_NAME_ERROR = "자동차 이름에 중복된 값이 있습니다.";

  public static void validateInputCarNames(String inputCarNames) {

    if (inputCarNames == null || inputCarNames.trim().isEmpty()) {
      throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
    }

    if (inputCarNames.contains(",")) {
      checkCommaSeparatedFormat(inputCarNames);
      return;
    }

    checkCarNameLength(inputCarNames);
  }

  private static void checkCommaSeparatedFormat(String inputCarName) {

    List<String> carNameList = Stream.of(inputCarName.split(","))
        .map(String::trim)
        .toList();

    if (carNameList.isEmpty()) {
      throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
    }

    if (carNameList.size() != new HashSet<>(carNameList).size()) {
      throw new IllegalArgumentException(DUPLICATE_CAR_NAME_ERROR);
    }

    for (String carName : carNameList) {
      checkCarNameLength(carName);
    }
  }

  private static void checkCarNameLength(String carName) {

    if (carName.length() == 0 || carName.length() > 5) {
      throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH_ERROR);
    }
  }

  public static void validateInputAttemptCount(String inputAttemptCount) {

    int parsedAttemptCount = parseAttemptCount(inputAttemptCount);
    checkAttemptCount(parsedAttemptCount);
  }

  private static int parseAttemptCount(String inputAttemptCount) {

    try {
      return Integer.parseInt(inputAttemptCount);
    } catch (Exception e) {
      throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT_ERROR);
    }
  }

  private static void checkAttemptCount(int attemptCount) {

    if (attemptCount < 0) {
      throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT_ERROR);
    }
  }
}
