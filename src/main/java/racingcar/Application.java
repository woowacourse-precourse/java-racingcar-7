package racingcar;

import controller.RacingController;
import java.util.List;
import view.InputView;

public class Application {
    public static void main(String[] args) {

        List<String> carsList = InputView.getCarNames();
        int raceRounds = InputView.getRaceRounds();

        RacingController controller = new RacingController(carsList, raceRounds);
        controller.startRace();

    }

}
