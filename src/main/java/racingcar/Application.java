package racingcar;

import racingcar.controller.CarRaceController;
import racingcar.view.CarRaceView;
public class Application {
    public static void main(String[] args) {
        CarRaceController carRaceController = new CarRaceController();
        carRaceController.startRace();
    }
}