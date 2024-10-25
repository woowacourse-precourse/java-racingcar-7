package racingcar;



import java.util.List;

import static racingcar.SystemMessage.*;

public class GameDirector {
    private final int count;
    private final CarList manager;

    public GameDirector(String carNames,String count, MoveStrategy moveStrategy) {
        manager = new CarList(moveStrategy);
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
