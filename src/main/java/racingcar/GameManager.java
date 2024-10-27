package racingcar;

import java.util.List;

public class GameManager {
    private RacingCarManager racingCarManager;
    private int tries;

    public void startGame() throws IllegalArgumentException {
        initializeGame();
        playGame();
        endGame();
    }

    private void initializeGame() {
        List<String> carNameList = UserInputUtil.getCarNames();
        this.tries = UserInputUtil.getTries();
        this.racingCarManager = new RacingCarManager(carNameList);
    }

    private void playGame() {
        System.out.println(RacingCarConstant.RESULT_HEADER_MESSAGE);
        for (int i = 0; i < tries; i++) {
            racingCarManager.playOneRound();
            GamePrinter.printRoundResult(racingCarManager.getCars());
        }
    }

    private void endGame() {
        List<String> winners = racingCarManager.findWinners();
        GamePrinter.printWinners(winners);
    }
}
