package racingcar;

import java.util.List;

public interface WinningPolicy {

    List<Car> determineWinners(List<Car> cars);

}
