package racingcar.service;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Race;

import racingcar.domain.RaceRule;

public class RaceService {
    private final RaceRule rule;
    private Race race;

    public RaceService(RaceRule rule) {
        this.rule = rule;
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
