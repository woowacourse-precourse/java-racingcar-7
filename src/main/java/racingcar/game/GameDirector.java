package racingcar.game;


import racingcar.util.Printer;

import java.util.List;

import static racingcar.util.SystemMessage.RESULT;

public class GameDirector {
    private final int count;
    private final CarManager manager;

    public GameDirector(List<String> carNames, int count) {
        manager = CarManager.createManager(carNames);
        this.count = count;
    }

    public List<Car> run() {
        return manager.moveCars(this.count);
    }

    public void printWinner(List<Car> matchResult) {
        String winner = manager.getWinners(matchResult);
        Printer.print(RESULT,winner);
    }
}
