package racingcar.application.view.validation;

import java.util.List;
import java.util.stream.Stream;

public class InputValidation {

  private static final String EMPTY_INPUT_ERROR = "자동차 이름은 비어있을 수 없습니다.";
  private static final String INVALID_CAR_NAME_LENGTH_ERROR = "자동차 이름은 1자 이상, 5자 이하로 입력해야 합니다.";

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

    for (String carName : carNameList) {
      checkCarNameLength(carName);
    }
  }

  private static void checkCarNameLength(String carName) {

    if (carName.length() == 0 || carName.length() > 5) {
      throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH_ERROR);
    }
  }
}
