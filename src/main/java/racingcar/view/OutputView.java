package racingcar.view;

import java.util.List;

public class OutputView {

  public static void printCarNamePrompt() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
  }

  public static void printGameCountPrompt() {
    System.out.println("시도할 횟수는 몇 회인가요?");
  }

  public static void printGameStartMessage() {
    System.out.println("\n실행 결과");
  }

  public static void printCarPositions(List<String> carStatuses) {
    for (String status : carStatuses) {
      System.out.println(status);
    }
    System.out.println();
  }
}
