package racingcar.common.io;

import java.util.List;

public class Output {

  public void printMessage(String msg) {
    System.out.println(msg);
  }

  public void printRaceProgress(String carName, int distance) {
    printMessage(carName + " : " + "-".repeat(distance));
  }

  public void printWinners(List<String> winners) {
    String result = String.join(", ", winners);
    printMessage("최종 우승자 : " + result);
  }
}
