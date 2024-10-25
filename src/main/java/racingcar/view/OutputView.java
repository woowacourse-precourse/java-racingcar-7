package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.utils.ConstantMessage;

public class OutputView {
    public void printNameGuide() {
        System.out.println(ConstantMessage.INPUT_NAME_MESSAGE);
    }

    public void printRoundGuide() {
        System.out.println(ConstantMessage.INPUT_ROUND_MESSAGE);
    }

    public void printExecuteResultGuide() {
        System.out.println(ConstantMessage.OUTPUT_RESULT_MESSAGE);
    }

    public void printRacingProgress(List<Car> carArrayList) {
        for (Car car : carArrayList) {
            printCarInfo(car);
        }
    }

    public void printCarInfo(Car car) {
        System.out.printf("%s : %s%n", car.getName(), "-".repeat(car.getDistance()));
    }
}
