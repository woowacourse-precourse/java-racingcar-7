package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        List<String> names = inputView.readNames();
        int trialCount = inputView.readTrialCount();
        Game game = new Game();
        game.play(names);

        for (int i = 0; i < trialCount; ++i) {
            outputView.noticeResult();
            game.play(names);
        }
        List<Car> results = game.judge();

        outputView.printStatusOf(results);
        outputView.printWinners(results);
    }

}
