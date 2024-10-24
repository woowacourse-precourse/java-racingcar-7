package racingcar.service;

import racingcar.model.Car;
import racingcar.model.RandomNumberGenerator;

import java.util.List;

public class GameService {
    private final RandomNumberGenerator randomNumberGenerator;

    public GameService(RandomNumberGenerator randomNumberGenerator){
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public List<Car> raceCar(List<Car> cars) {
        for(Car car : cars){
            int randomNumber = randomNumberGenerator.makeRandomNumber();
            car.move(randomNumber);
        }
        return cars;
    }
}
