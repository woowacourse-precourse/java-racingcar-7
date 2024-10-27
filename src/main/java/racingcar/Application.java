package racingcar;

import racingcar.controller.RaceController;
import racingcar.model.RaceModel;
import racingcar.view.ConsoleView;

public class Application {

    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        RaceModel raceModel = new RaceModel();
        RaceController raceController = new RaceController(view, raceModel);

        raceController.startRace();
    }
}