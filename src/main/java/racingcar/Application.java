package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.ParsingCarNameService;

public class Application {
    public static void main(String[] args) {
        ParsingCarNameService parsingCarNameService = new ParsingCarNameService();
        RacingCarController racingCarController = new RacingCarController(parsingCarNameService);
        racingCarController.startRacingGame();
    }
}
