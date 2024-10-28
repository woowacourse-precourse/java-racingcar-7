package racingcar;

import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private int turn;

    public RacingGame(List<Car> cars, int turn) {
        this.cars = cars;
        this.turn = turn;
    }

    public void start() {
        System.out.println("실행 결과");

        while (turn-- > 0) {
            cars.forEach(Car::randomMove);
            cars.forEach(Car::displayPosition);
            System.out.println();
        }
    }

}
