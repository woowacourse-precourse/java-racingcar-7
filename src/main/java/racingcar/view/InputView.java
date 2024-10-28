package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import racingcar.vaildator.InputValidator;

public class InputView {
  static private final String CAR_NAME_GUIDE = "자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)\n스페이스 사용 금지\n";
  static private final String NUM_ATTEMPT_GUIDE = "움직일 횟수를 정해주세요\n";

  static public String[] inputCarName() {
    String carName = requestCarNamePrompt();

    String[] names = splitCarName(carName);

    return names;
  }

  static public int inputNumAttempt() {
    int numAttempt = requestNumAttemptPrompt();


    return numAttempt;
  }

  static private String requestCarNamePrompt() {
    printInputMessage(CAR_NAME_GUIDE);
    String carName = Console.readLine();

    InputValidator.validateInputCarName(carName);

    return carName;
  }

 static private int requestNumAttemptPrompt() {
    printInputMessage(NUM_ATTEMPT_GUIDE);
    String numAttempt = Console.readLine();

    InputValidator.validateInputNumAttempt(numAttempt);

    return Integer.parseInt(numAttempt);
  }

  static private void printInputMessage(String message) {
    System.out.println(message);
  }

  static String[] splitCarName(String carName) {
    String[] names = carName.split(",");

    for (String name : names) {
      int nameLen = name.length();
      if (nameLen < 1) {
        throw new IllegalArgumentException("자동차 이름은 1글자는 되어야 합니다. " + name);
      }
      if (nameLen > 5) {
        throw new IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다. "+name );
      }
    }
    return names;

  }


}
