package racingcar.View;

import java.util.List;
import racingcar.Model.Car;

public class OutputView {
    public void printProgressStatus(List<Car> cars) {
        StringBuilder builder = new StringBuilder();

        cars.forEach(car -> {
            builder.append(car.getCarName() + " : ");
            builder.append("-".repeat(car.getDistance()));
            builder.append("\n");
        });

        System.out.println(builder);
    }

    public void printWinners(List<Car> cars) {
        StringBuilder builder = new StringBuilder();

        builder.append("최종 우승자 : ");
        builder.append(cars.get(0).getCarName());

        for (int i = 1; i < cars.size(); i++) {
            builder.append(", ").append(cars.get(i).getCarName());
        }

        System.out.println(builder);
    }
}
