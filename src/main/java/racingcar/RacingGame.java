package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int moveCount;
    private final MoveStrategy moveStrategy;

    public RacingGame(List<String> carNames, int moveCount, MoveStrategy moveStrategy) {
        if (moveCount < 1) {
            throw new IllegalArgumentException("이동 횟수는 1 이상이어야 합니다.");
        }

        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }

        this.cars = carList;
        this.moveCount = moveCount;
        this.moveStrategy = moveStrategy;
    }

    public void startRace() {
        for (int i = 0; i < moveCount; i++) {
            for (Car car : cars) {
                car.move(moveStrategy);
            }
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
