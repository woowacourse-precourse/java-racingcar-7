package racingcar;

import racingcar.controller.MainController;
import racingcar.service.RaceService;

public class Application {
    public static void main(String[] args) {
        RaceService raceService = new RaceService();
        MainController mainController = new MainController(raceService);
        mainController.run();
    }
}
