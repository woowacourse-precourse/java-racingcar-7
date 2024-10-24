package racingcar;

import racingcar.controller.CarRaceController;
import racingcar.view.CarRaceView;
public class Application {
    public static void main(String[] args) {
        CarRaceView view = new CarRaceView();
        CarRaceController controller = new CarRaceController(view);
        controller.startRace();
    }
}
