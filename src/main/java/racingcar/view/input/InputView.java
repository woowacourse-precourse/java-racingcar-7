package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 25.
 */
public class InputView {
  private static final String ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
  private static final String ASK_ROUND_COUNT = "시도할 횟수는 몇 회인가요?";

  private static String promptCarNames(){
    System.out.println(ASK_CAR_NAMES);
    return Console.readLine();
  }

  private static String promptRoundCount(){
    System.out.println(ASK_ROUND_COUNT);
    return Console.readLine();
  }
}
