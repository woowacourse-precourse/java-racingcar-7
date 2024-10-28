package racingcar.view;

import java.util.List;

public class OutputView {
  public static void printWinners(List<String> winners) {
    System.out.print("최종 우승자 : " + String.join(", ", winners));
  }
}
