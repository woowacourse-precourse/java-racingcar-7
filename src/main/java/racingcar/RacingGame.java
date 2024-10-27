package racingcar;

import java.util.stream.IntStream;

public class RacingGame {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        String carNames = inputView.readCarNames();
        Cars cars = new Cars(carNames);
        int tryCount = inputView.readTryCount();

        outputView.printGameStart();
        playGame(cars, tryCount);
        outputView.printWinners(cars.getWinners());
    }

    private void playGame(final Cars cars, final int tryCount) {
        IntStream.range(0, tryCount).forEach(i -> {
            cars.moveAll();
            outputView.printRoundResult(cars);
        });
    }
}
