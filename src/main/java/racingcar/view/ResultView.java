package racingcar.view;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import java.util.stream.IntStream;

public class ResultView {
    private static final String RESULT_DELIMITER = " : ";
    private static final String MOVE_MARKER = "-";
    private final Cars cars;

    public ResultView(Cars cars) {
        this.cars = cars;
    }

    public void moveCarResultView() {
        for (Car car : cars.getCars()) {
            System.out.print(car.getName() + RESULT_DELIMITER);
            IntStream.range(0, car.getMoveNumber()).forEach(number -> System.out.print(MOVE_MARKER));
            System.out.println();
        }
    }

}
