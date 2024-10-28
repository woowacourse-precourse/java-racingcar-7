package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        
        InputHandler inputHandler = new InputHandler();
        InputView inputView = new InputView(inputHandler);

        List<String> carNames = inputView.requestCarNames();
        int attemptNumber = inputView.requestAttemptNumber();

        RacingGame racingGame = new RacingGame(carNames);
        racingGame.play(attemptNumber);

        List<RoundResult> roundResults = racingGame.getRoundResults();
        OutputView.displayResults(roundResults);

        List<String> winners = racingGame.findWinners();
        OutputView.displayWinners(winners);
    }
}
