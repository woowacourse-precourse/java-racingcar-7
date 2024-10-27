package racingcar.domain;

import racingcar.util.RandomGenerator;

import java.util.List;

public class RacingGame {
    private List<Car> carList;
    private final RacingRule racingRule;

    public RacingGame() {
        this.racingRule = new RacingRule();
    }

    public void setCars(List<Car> carList) {

        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void play() {
        for (Car car : carList) {
            moveCar(car);
        }
    }

    private void moveCar(Car car) {
        int randomNumber = RandomGenerator.generateRandomNumber();
        car.move(randomNumber, racingRule);
    }

}
