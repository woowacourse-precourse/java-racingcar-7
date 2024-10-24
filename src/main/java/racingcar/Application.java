package racingcar;

import racingcar.controller.RaceController;
import racingcar.view.ConsoleView;

public class Application {

    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        RaceController raceController = new RaceController(view);
        raceController.startRace();
    }
}