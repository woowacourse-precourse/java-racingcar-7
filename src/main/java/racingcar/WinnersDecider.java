package racingcar;

import java.util.List;

public class WinnersDecider {

    private final WinningPolicy winningPolicy;

    public WinnersDecider(WinningPolicy winningPolicy) {
        this.winningPolicy = winningPolicy;
    }

    public List<Car> run(final List<Car> cars) {
        return winningPolicy.determineWinners(cars);
    }

}
