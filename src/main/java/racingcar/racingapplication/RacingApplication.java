package racingcar.racingapplication;

import java.util.ArrayList;
import java.util.List;
import racingcar.RandomNumberGenerator;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingApplication {

    private final RandomNumberGenerator randomNumberGenerator;

    public RacingApplication(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public List<Cars> race(int gameNumber, List<Cars> allCars) {
        if (gameNumber == 0) {
            return allCars;
        }
        List<Car> allCar = allCars.getLast().allCar();
        Cars nextCars = eachRace(allCar);
        allCars.add(nextCars);
        return race(gameNumber - 1, allCars);
    }

    private Cars eachRace(List<Car> allCar) {
        List<Car> afterEachRaceCars = new ArrayList<>();
        for (Car car : allCar) {
            Car updateCar = car.updateDistance(car, randomNumberGenerator.isFollowNumberRule());
            afterEachRaceCars.add(updateCar);
        }
        return new Cars(afterEachRaceCars);
    }
}
