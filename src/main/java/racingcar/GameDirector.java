package racingcar;



import java.util.List;

import static racingcar.SystemMessage.*;

public class GameDirector {
    private final int count;
    private final CarManager manager = new CarManager();

    public GameDirector(String carNames,String count) {
        manager.add(carNames);
        this.count = Validator.validateCountIfNegative(count);
    }

    public List<Car> run() {
        return manager.moveCars(this.count);
    }

    public void printWinner(List<Car> matchResult) {
        String winner = manager.getWinner(matchResult);
        Printer.print(RESULT,winner);
    }
}
