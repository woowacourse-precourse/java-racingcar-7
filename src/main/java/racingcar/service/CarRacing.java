package racingcar.service;

import java.util.List;

public class CarRacing {
    private final RacingRule racingRule;
    private final Racers racers;

    public CarRacing(RacingRule racingRule, Racers racers) {
        this.racingRule = racingRule;
        this.racers = racers;
    }

    public List<String> playARound() {
        racers.tryToMoveWith(racingRule);
        return racers.getCurrentResult();
    }

    public List<String> announceWinners() {
        return racers.getWinnerNames();
    }
}