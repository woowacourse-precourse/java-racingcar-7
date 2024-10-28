package racingcar.common.io;

import java.util.List;
import racingcar.domain.dto.CarDTO;

public class Output {

  public void printMessage(String msg) {
    System.out.println(msg);
  }

  public void printRaceProgress(CarDTO carDTO) {
    printMessage(carDTO.name() + " : " + "-".repeat(carDTO.position()));
  }

  public void printWinners(List<String> winners) {
    String result = String.join(", ", winners);
    printMessage("최종 우승자 : " + result);
  }
}
