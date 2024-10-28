package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputView.readCarNames();
        int trialCount = InputView.readTrialCount();
        RacingGame racingGame = new RacingGame(carNames, trialCount);
        System.out.println("실행 결과");
        racingGame.play();
        List<String> winners = racingGame.getWinners();
        ResultView.printWinners(winners);
    }
}