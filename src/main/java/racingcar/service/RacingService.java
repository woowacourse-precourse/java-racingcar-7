package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.model.RaceResult;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingService {

    public RaceResult runRace(String carNames, int attempts) {
        List<Car> carList = Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
        Race race = new Race(carList);

        for (int i = 0; i < attempts; i++) {
            race.proceed();
        }

        return new RaceResult(race.getCars());
    }
}
