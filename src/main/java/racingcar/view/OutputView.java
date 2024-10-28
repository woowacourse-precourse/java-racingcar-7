package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public static void showOutputView(List<String> names) {
        StringBuilder winners = new StringBuilder("최종 우승자 : ");
        String strNames = String.join(", ", names);
        winners.append(strNames);
        System.out.print(winners);
    }

    public static void printProgressRacing(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

}
