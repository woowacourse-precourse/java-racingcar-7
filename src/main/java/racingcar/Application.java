package racingcar;

import racingcar.controller.RacingController;
import racingcar.converter.StringToIntegerConverter;

public class Application {
    public static void main(String[] args) {
        StringToIntegerConverter converter = new StringToIntegerConverter();

        RacingController racingController = new RacingController(converter);
        racingController.startGame();
    }
}
