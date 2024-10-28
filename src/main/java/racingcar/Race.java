package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> carList;
    private final int moveCount;
    private int maxScore;

    public Race(List<String> carNames, int moveCount) {
        this.carList = new ArrayList<>();
        for (String carName : carNames) {
            this.carList.add(new Car(carName));
        }
        this.moveCount = moveCount;
        this.maxScore = 0;
    }
}
