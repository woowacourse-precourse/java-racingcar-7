package racingcar.application;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Result;

public class RacingApplication {

    private final NumberGenerator numberGenerator;

    public RacingApplication(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Result race(Cars cars, int gameNumber) {
        List<Cars> list = new ArrayList<>();
        list.add(cars);
        List<Cars> afterRaceCars = doRace(gameNumber, list);
        return Result.of(afterRaceCars.subList(1, afterRaceCars.size()));
    }

    private List<Cars> doRace(int gameNumber, List<Cars> allCars) {
        if (gameNumber == 0) {
            return allCars;
        }
        List<Car> allCar = allCars.getLast().allCar();
        Cars nextCars = eachRace(allCar);
        allCars.add(nextCars);
        return doRace(gameNumber - 1, allCars);
    }

    private Cars eachRace(List<Car> allCar) {
        List<Car> afterEachRaceCars = new ArrayList<>();
        for (Car car : allCar) {
            Car updateCar = car.updateDistance(car, numberGenerator.isFollowNumberRule());
            afterEachRaceCars.add(updateCar);
        }
        return new Cars(afterEachRaceCars);
    }
}
