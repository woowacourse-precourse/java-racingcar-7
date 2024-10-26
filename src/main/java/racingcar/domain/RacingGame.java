package racingcar.domain;

public class RacingGame {

    private final CarContainer carContainer;

    public RacingGame(String invalidCarNames) {
        CarsParser CarsParser = new CarsParser();

        this.carContainer = new CarContainer(CarsParser.parse(invalidCarNames));
    }

    public String proceedRound() {
        carContainer.moveAll();

        return carContainer.getCurrentRoundResult();
    }

    public String findWinnerCarNames() {
        return carContainer.findWinnerCarNames();
    }
}
