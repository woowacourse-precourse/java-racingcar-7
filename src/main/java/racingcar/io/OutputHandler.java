package racingcar.io;

import java.util.List;
import racingcar.Car;

public interface OutputHandler {

    void showRacingCarNameComment();

    void showRacingCarNumberComment();

    void showRaceResults(List<Car> cars);

    void showRaceWinner(List<String> winners);

}
