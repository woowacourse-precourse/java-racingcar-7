package racingcar.domain;

import racingcar.presentation.RaceResultFormatter;

public class RacingGame {
    private final RaceResultFormatter raceResultFormatter;
    private final Cars cars;
    private final Rounds rounds;

    public RacingGame(Cars cars, Rounds rounds) {
        this.raceResultFormatter = new RaceResultFormatter();
        this.cars = cars;
        this.rounds = rounds;
    }

    public String play() {
        StringBuilder raceResult = new StringBuilder();

        for (int i = 0; i < rounds.value(); i++) {
            cars.moveAll();
            raceResult.append(raceResultFormatter.formatPositions(cars));
        }

        raceResult.append(raceResultFormatter.formatWinnerNames(cars.getWinnerNames()));
        return raceResult.toString();
    }
}
