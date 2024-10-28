package racingcar;

import racingcar.controller.GameController;
import racingcar.service.RaceService;

public class Application {
    public static void main(String[] args) {
        RaceService raceService = new RaceService();
        GameController gameController = new GameController(raceService);
        gameController.start();
    }
}