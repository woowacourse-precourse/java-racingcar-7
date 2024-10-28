package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public static void printResult(List<Car> carList) {
        for (Car car : carList) {
            String position = "-".repeat(car.getPosition());
            System.out.println(String.format("%s : %s", car.getName(), position));
        }
        System.out.println();
    }

    public static void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}