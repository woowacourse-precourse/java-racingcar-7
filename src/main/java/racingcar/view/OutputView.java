package racingcar.view;

import java.util.List;
import racingcar.dto.CarStatusDTO;
import racingcar.util.Constants;

public class OutputView {

  public void printGameStartMessage() {
    System.out.println(Constants.GAME_START_MESSAGE);
  }

  public void printCarPositions(List<CarStatusDTO> carStatuses) {
    for (CarStatusDTO status : carStatuses) {
      printCarPosition(status);
    }
    System.out.println();
  }

  private void printCarPosition(CarStatusDTO status) {
    String positionIndicator = "-".repeat(status.getPosition());
    System.out.println(status.getName() + " : " + positionIndicator);
  }

  public void printWinners(List<String> winners) {
    String winnersNames = String.join(Constants.JOIN_DELIMITER, winners);
    System.out.println(Constants.WINNERS_MESSAGE_PREFIX + winnersNames);
  }
}
