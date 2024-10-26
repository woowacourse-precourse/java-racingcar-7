package racingcar.service;

import java.util.Arrays;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.generator.NumberGenerator;
import racingcar.domain.Race;

import racingcar.domain.RaceRule;
import racingcar.domain.generator.RandomNumberGenerator;
import racingcar.domain.Round;
import racingcar.request.CarCreateRequest;

public class RaceService {
    private final Race race;

    public RaceService(CarCreateRequest request) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        List<Car> cars = Arrays.stream(request.getNames()).map(Car::new).toList();
        Round round = new Round(request.getTryCount());
        RaceRule rule = new RaceRule(numberGenerator);

        this.race = new Race(round, cars, rule);
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
