package racingcar.domain;

public class RacingGame {

    private final Cars cars;

    public RacingGame(String invalidCarNames) {
        CarsParser CarsParser = new CarsParser();
        cars = new Cars(CarsParser.parse(invalidCarNames));
    }

    public String proceedRound() {
        cars.moveAll();

        return cars.getCurrentRoundResult();
    }

    public String findWinner() {
        return cars.findWinnerCarNames();
    }
}
