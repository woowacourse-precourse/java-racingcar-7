package racingcar;

import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private int moveCount;

    public RacingGame(List<Car> cars, int moveCount) {
        this.cars = cars;
        this.moveCount = moveCount;
    }

    void playTurn() {
        for (Car car : cars) {
            car.move();
            System.out.println(car.getStatus());
        }
    }

    void playGame() {
        for (int i = 0; i < moveCount; i++) {
            playTurn();
        }
    }
}
