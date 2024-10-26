package racingcar.game;

import racingcar.data.GameData;
import racingcar.dto.Car;
import racingcar.util.NumberGenerator;
import racingcar.util.Random;

import java.util.List;

public class RacingGameRound {
    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    public RacingGameRound(List<Car> carList, NumberGenerator numberGenerator) {
        this.cars = carList;
        this.numberGenerator = numberGenerator;
    }

    public RacingGameRound(List<Car> carList) {
        this.cars = carList;
        this.numberGenerator = new Random();
    }

    public void racing(GameData gameData) {
        for (int indexOfCar = 0; indexOfCar < cars.size(); indexOfCar++) {
            Car car = cars.get(indexOfCar);
            checkConditionAndMove(car);
        }
        gameData.save(cars);
    }

    private void checkConditionAndMove(Car car) {
        if (numberGenerator.pickNumber() >= 4) {
            car.move();
        }
    }
}
