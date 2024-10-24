package racingcar.service;

import java.util.Arrays;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.GenerateNumberStrategy;
import racingcar.domain.Race;
import racingcar.domain.RandomGenerateNumberStrategy;
import racingcar.domain.Round;
import racingcar.request.CarCreateRequest;

public class RaceService {
    private final Race race;

    public RaceService(CarCreateRequest request) {
        List<Car> cars = Arrays.stream(request.getNames()).map(Car::new).toList();
        Round round = new Round(request.getTryCount());
        GenerateNumberStrategy strategy = new RandomGenerateNumberStrategy();

        this.race = new Race(round, cars, strategy);
    }

    public List<Car> proceed() {
        return race.proceed();
    }

    public List<Car> getWinner() {
        return race.getWinner();
    }

    public boolean isGameEnd() {
        return race.isGameEnd();
    }
}
