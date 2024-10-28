package racingcar.view.output;

import java.util.List;
import racingcar.model.Car;

public interface OutPutView {

    void printMessage();

    void printResult(final List<Car> cars);

    void printWinners(final List<Car> winners);
}
