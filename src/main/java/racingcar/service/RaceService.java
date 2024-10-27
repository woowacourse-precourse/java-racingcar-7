package racingcar.service;

import java.util.Arrays;
import java.util.List;

import racingcar.domain.Car;
import racingcar.utils.generator.NumberGenerator;
import racingcar.domain.Race;

import racingcar.domain.RaceRule;
import racingcar.utils.generator.RandomDigitsGenerator;

public class RaceService {
    private final RaceRule rule;
    private Race race;

    public RaceService() {
        NumberGenerator numberGenerator = new RandomDigitsGenerator();
        this.rule = new RaceRule(numberGenerator);
    }

    public void createRace(List<String> names, int tryCount) {
        this.race = new Race(tryCount, names, rule);
    }

    public List<Car> playRound() {
        return race.proceed();
    }

    public boolean isGameEnd() {
        return race.isGameEnd();
    }

    public List<Car> getWinner() {
        return race.getWinner();
    }
}
