package racingcar.game;


import racingcar.exception.Validator;
import racingcar.strategy.Condition;
import racingcar.util.Printer;

import java.util.List;

import static racingcar.util.SystemMessage.RESULT;

public class GameDirector {
    private final int count;
    private final CarList manager;

    public GameDirector(String carNames, String count, Condition condition) {
        manager = new CarList(condition);
        manager.add(carNames);
        this.count = Validator.validateCountIfNegative(count);
    }

    public List<Car> run() {
        return manager.moveCars(this.count);
    }

    public void printWinner(List<Car> matchResult) {
        String winner = manager.getWinners(matchResult);
        Printer.print(RESULT,winner);
    }
}
