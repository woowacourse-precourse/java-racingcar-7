package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.model.Car;
import racingcar.view.RacingCarView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        RacingCarView racingCarView = new RacingCarView();
        RacingCarController controller = new RacingCarController(racingCarView);
        controller.play();
    }
}
