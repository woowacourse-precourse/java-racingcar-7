package racingcar;

import racingcar.controller.RaceController;
import racingcar.domain.validator.CarNameValidator;
import racingcar.domain.validator.TrialCountsValidator;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RaceController raceController = new RaceController(new CarNameValidator(), new TrialCountsValidator(), new OutputView());
        raceController.start();
    }
}
