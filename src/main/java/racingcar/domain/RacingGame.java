package racingcar.domain;

import racingcar.util.RandomDigitGenerator;
import racingcar.util.RandomGenerator;

public class RacingGame {

    private final Cars cars;

    public RacingGame(String invalidCarNames) {
        CarsParser CarsParser = new CarsParser();
        RandomGenerator randomGenerator = new RandomDigitGenerator();

        cars = new Cars(CarsParser.parse(invalidCarNames), randomGenerator);
    }

    public String proceedRound() {
        cars.moveAll();

        return cars.getCurrentRoundResult();
    }

    public String findWinner() {
        return cars.findWinnerCarNames();
    }
}
