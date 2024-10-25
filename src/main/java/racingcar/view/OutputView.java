package racingcar.view;

import java.util.List;

public class OutputView {

  public void printResult() {
    System.out.println("\n실행 결과\n");
  }

  public void printCarAndMoveCount(String carName, int position) {
    System.out.println(carName + " : " + "-".repeat(position));
  }

  public void printLastWinner(List<String> winners) {
    System.out.printf("최종 우승자 : " + String.join(", ", winners)+"\n");
  }
}
