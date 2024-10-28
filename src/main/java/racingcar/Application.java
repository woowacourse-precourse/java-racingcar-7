package racingcar;

import racingcar.controller.Racing;
import racingcar.service.CarService;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {

        Racing racing = new Racing();

        racing.playGame();
    }
}
