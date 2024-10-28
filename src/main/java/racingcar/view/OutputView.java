package racingcar.view;

import racingcar.message.IOMessage;
import racingcar.model.Car;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printRunResult() {
        System.out.println(IOMessage.OUTPUT_RESULT_MESSAGE.getMessage());
    }

    public static void printCarPositions(Map<String, Car> cars) {
        // 자동차 이동할때마다 이동 거리 출력
        for (Car car : cars.values()) {
            System.out.println(String.format(IOMessage.CAR_MOVE_MESSAGE.getMessage(), car.getName(), car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        // 우승자 출력
        System.out.println(IOMessage.OUTPUT_MESSAGE.getMessage() + String.join(", ", winners));
    }
}
