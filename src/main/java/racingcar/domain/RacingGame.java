package racingcar.domain;

public class RacingGame {

    private final Cars cars;

    public RacingGame(String invalidCarNames) {
        cars = new Cars(invalidCarNames);
    }

    public String proceedRound() {
        cars.moveAll();

        return cars.getCurrentRoundResult();
    }

    public String findWinner() {
        return cars.findWinnerCarNames();
    }
}
