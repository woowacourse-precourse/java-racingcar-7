package racingcar.domain.winnerdecider;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.winnerdecider.policy.WinningPolicy;

public class WinnersDecider {

    private final WinningPolicy winningPolicy;

    public WinnersDecider(WinningPolicy winningPolicy) {
        this.winningPolicy = winningPolicy;
    }

    public List<Car> run(final List<Car> cars) {
        return winningPolicy.determineWinners(cars);
    }

}
