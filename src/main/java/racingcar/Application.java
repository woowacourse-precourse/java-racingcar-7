package racingcar;


import racingcar.controller.RacingCarGameController;
import racingcar.factory.BasicRacingCarGameFactory;

public class Application {
    public static void main(String[] args) {
        RacingCarGameController controller = new RacingCarGameController(BasicRacingCarGameFactory.getRacingCarGame());
        controller.run();
    }
}
