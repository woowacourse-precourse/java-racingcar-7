package racingcar.io;

import java.util.List;
import racingcar.car.Car;

public interface OutputHandler {

    void showRacingCarNameComment();

    void showRacingCarNumberComment();

    void showResultComment();

    void showRaceResults(List<Car> cars);

    void showRaceWinner(List<String> winners);

}
