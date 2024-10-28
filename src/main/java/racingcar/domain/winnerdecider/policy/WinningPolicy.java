package racingcar.domain.winnerdecider.policy;

import java.util.List;
import racingcar.domain.Car;

public interface WinningPolicy {

    List<Car> determineWinners(List<Car> cars);

}
