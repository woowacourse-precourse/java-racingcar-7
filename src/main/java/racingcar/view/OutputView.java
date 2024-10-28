package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public static void showOutputView(List<String> names) {
        StringBuilder winners = new StringBuilder("최종 우승자 : ");
        for (int i = 0; i < names.size(); i++) {
            if (i < names.size() - 1) {
                winners.append(names.get(i)).append(", ");
            } else {
                winners.append(names.get(i));
            }
        }
        System.out.print(winners);
    }

    public static void printProgressRacing(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

}
