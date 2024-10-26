package racingcar.controller;

import java.util.List;
import racingcar.domain.InputParser;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class GameController {
    public void run() {
        List<String> carNames = InputParser.parseCarNames(InputView.getCarNames());
        int rounds = InputParser.parseRounds(InputView.getRounds());
        GameService racingGame = new GameService(carNames);

        for (int i = 0; i < rounds; i++) {
            racingGame.playRound();
            ResultView.printRoundResult(racingGame.getCars());
        }
        ResultView.printWinners(racingGame.getWinners());
    }
}
