package racingcar.domain;

import java.util.List;

public class GameBoard {
    private List<Car> cars;
    public GameBoard(List<Car> cars) {
        this.cars = cars;
    }
    public List<Car> getCars() {
        return cars;
    }
    public void playRound() {
        for (Car car : cars) {
            car.move();
        }
    }
}
