package racingcar.controller;

import java.util.List;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final RacingGame racingGame;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(RacingGame racingGame, InputView inputView, OutputView outputView) {
        this.racingGame = racingGame;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {

        List<String> carNames = inputView.getCarNames();
        int count = inputView.getRaceCount();

        // Model에서 경주 초기화 및 로직 처리
        racingGame.initializeCars(carNames);
        racingGame.race(count);

        // 결과 출력
        outputView.printWinner(racingGame.findWinners());
    }
}
