package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingCarController;

import java.util.List;

public class RacingCarView {

  public String inputCarNames() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    return Console.readLine();
  }

  public String inputNumberOfAttempts(){
    System.out.println("시도할 횟수는 몇 회인가요?");
    return Console.readLine();
  }

  public void displayResults(List<String> winnersList) {
    System.out.print("최종 우승자 : ");
    System.out.print(String.join(",", winnersList));
  }
}
