package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.error.ErrorMessage;
import racingcar.model.parseCar.ParseCar;

public class InputView {

  private final static String INPUT_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
  private final static String INPUT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

  private String inputCarStr;
  private Integer inputCount;

  private InputView() {
  }

  public static String inputCarStr() {
    //차 이름 입력
    System.out.println(INPUT_CAR_MESSAGE);
    String inputCarStr = Console.readLine();

    if (!validateInputCarStr(inputCarStr)) {
      throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_STRING.getMessage());
    }
    if (!validateInputCarDelmiter(inputCarStr)) {
      throw new IllegalArgumentException(ErrorMessage.NO_DELIMITER_CAR_STRING.getMessage());
    }

    return inputCarStr;


  }

  public static Integer inputCount() {
    //횟수 입력
    System.out.println(INPUT_COUNT_MESSAGE);
    String inputCount = Console.readLine();

    if (!validateInputCountIsNum(inputCount)) {
      throw new IllegalArgumentException(ErrorMessage.NO_NUMBER_COUNT_STRING.getMessage());
    }

    return Integer.parseInt(inputCount);
  }

  private static boolean validateInputCarStr(String inputCarStr) {
    if (inputCarStr.isBlank() || inputCarStr == null) {
      return false;
    }
    return true;
  }

  private static boolean validateInputCarDelmiter(String inputCarStr) {
    if (!inputCarStr.contains(ParseCar.DELIMITER)) {
      return false;
    } else {
      return true;
    }
  }

  private static boolean validateInputCountIsNum(String inputCount) {
    try {
      Integer num = Integer.parseInt(inputCount);
      if (num <= 0) {
        return false;
      }
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }


}
