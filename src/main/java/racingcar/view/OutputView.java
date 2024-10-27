package racingcar.view;

import java.util.List;


public class OutputView {

  public void printGameStartMessage() {
    System.out.println(GameMessages.GAME_START_MESSAGE);
  }

  public void printCarPositions(List<CarStatusDTO> carStatuses) {
    for (CarStatusDTO status : carStatuses) {
      printCarPosition(status);
    }
    System.out.println();
  }

  private void printCarPosition(CarStatusDTO status) {
    String positionIndicator = "-".repeat(status.position());
    System.out.println(status.name() + " : " + positionIndicator);
  }

  public void printWinners(List<String> winners) {
    String winnersNames = String.join(GameMessages.JOIN_DELIMITER, winners);
    System.out.println(GameMessages.WINNERS_MESSAGE_PREFIX + winnersNames);
  }
}
