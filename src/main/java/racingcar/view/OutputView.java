package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;

public class OutputView {

    private final String RESULT_MSG = "실행 결과";

    public void outputResultMessage() {
        System.out.println(RESULT_MSG);
    }

    public void outputOneRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }
}
