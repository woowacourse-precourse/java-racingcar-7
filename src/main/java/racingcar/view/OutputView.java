package racingcar.view;

import racingcar.controller.Race;
import racingcar.model.Car;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class OutputView {

    public void printRoundResult(List<Car> cars) {

        StringBuilder sb = new StringBuilder();
        for(Car car : cars) {
            sb.append(car.getName()+" : ");
            sb.append("-".repeat(Math.max(0, car.getPosition())));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
