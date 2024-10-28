package racingcar.game;


import racingcar.util.Printer;

import java.util.List;
import java.util.stream.IntStream;

import static racingcar.util.SystemMessage.RESULT;

public class GameDirector {
    private final int circleCount;
    private final CarManager manager;

    public GameDirector(List<String> carNames, int circleCount) {
        manager = CarManager.createManager(carNames);
        this.circleCount = circleCount;
    }

    public void run() {
        IntStream.range(0, this.circleCount).forEach(i -> {
            manager.moveCars();
            manager.printCarListCurrentPosition();
        });
        printWinner();
    }

    private void printWinner() {
        String winner = manager.getWinners();
        Printer.print(RESULT,winner);
    }
}
