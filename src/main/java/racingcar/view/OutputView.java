package racingcar.view;

import java.util.ArrayList;
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

    public void printResultMessage() {
        System.out.println(ConstantMessage.OUTPUT_RESULT_MESSAGE);
    }

    public void printExecuteResult(ArrayList<Car> winners) {
        System.out.printf(ConstantMessage.OUTPUT_WINNER_MESSAGE);
        ArrayList<String> nameList = new ArrayList<>();
        for (Car car : winners) {
            nameList.add(car.getName());
        }
        System.out.println(String.join(", ", nameList));
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
