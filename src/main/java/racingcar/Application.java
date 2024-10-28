package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.RacingCarView;

public class Application {
  public static void main(String[] args) {
    RacingCarController racingCarController = new RacingCarController();
    racingCarController.startRace();
  }
}
