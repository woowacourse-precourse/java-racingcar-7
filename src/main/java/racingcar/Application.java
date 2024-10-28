package racingcar;

import racingcar.controller.CarRaceController;

public class Application {

    public static void main(String[] args) {
        CarRaceController controller = new CarRaceController();
        controller.startRace();
    }
}
