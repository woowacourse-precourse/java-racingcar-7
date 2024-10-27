package racingcar.service;

import java.util.Arrays;
import java.util.List;

import racingcar.domain.Car;
import racingcar.utils.generator.NumberGenerator;
import racingcar.domain.Race;

import racingcar.domain.RaceRule;
import racingcar.utils.generator.RandomDigitsGenerator;
import racingcar.domain.Round;
import racingcar.request.CarCreateRequest;

public class RaceService {
    private final Race race;

    public RaceService(CarCreateRequest request) {
        NumberGenerator numberGenerator = new RandomDigitsGenerator();
        List<String> names = Arrays.stream(request.getNames()).toList();
        int totalRound = request.getTryCount();
        RaceRule rule = new RaceRule(numberGenerator);

        this.race = new Race(totalRound, names, rule);
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
