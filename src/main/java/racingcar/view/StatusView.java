package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

import static racingcar.message.InfoMessage.STATUS_NOTIFICATION_MESSAGE;

public class StatusView {

    public static void printExecutionResult(){
        System.out.println(STATUS_NOTIFICATION_MESSAGE.getMessage());
    }

    public static void printStatus(List<Car> cars) {
        cars.forEach(Car::getStatus);
        System.out.println();
    }
}
