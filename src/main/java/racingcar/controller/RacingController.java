package racingcar.controller;

import java.util.List;
import racingcar.model.Parser;
import racingcar.model.Racing;
import racingcar.view.InputView;

public class RacingController {

    private final Racing racing;
    private final Parser parser;

    public RacingController() {
        this.racing = new Racing();
        this.parser = new Parser();
    }

    public void run() {
        String carNamesString = InputView.readCarNames();
        List<String> carNames = parser.parseCarName(carNamesString);

        String countString = InputView.readCount();
        int count = parser.parseCount(countString);

        racing.initialize(carNames);
        racing.race(count);
        racing.determineWinner();
    }
}
