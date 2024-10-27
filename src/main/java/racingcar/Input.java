package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
  public static String[] carName() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String[] names = Console.readLine().split(",");
    if (names.length == 0) {
      throw new IllegalArgumentException("자동차 이름이 공백입니다.");
    }
    for (String s : names) {
      if (s.isEmpty() || s.length() > 5) {
        throw new IllegalArgumentException("자동차 이름이 공백이거나 5자를 초과하였습니다.");
      }
    }
    return names;
  }

  public static int count() {
    System.out.println("시도할 횟수는 몇 회인가요?");
    String s = Console.readLine();
    try {
      Integer.parseInt(s);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("시도 횟수는 숫자로 입력하시기 바랍니다.");
    }
    if (Integer.parseInt(s) < 0) {
      throw new IllegalArgumentException("시도 횟수는 양수로 입력하시기 바랍니다.");
    }
    return Integer.parseInt(s);
  }
}