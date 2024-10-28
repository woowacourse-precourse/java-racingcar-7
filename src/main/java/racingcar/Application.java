package racingcar;

import racingcar.controller.RaceController;
import racingcar.util.Parser;
import racingcar.util.CarValidator;
import racingcar.util.RaceValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new CarValidator(), new RaceValidator(), new Parser());
        OutputView outputView = new OutputView();
        RaceController raceController = new RaceController(inputView, outputView);

        raceController.startRace();
    }
}
