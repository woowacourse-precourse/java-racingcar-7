package racingcar.view;

import racingcar.domain.Cars;

import java.util.Iterator;
import java.util.Map;

public class OutputView {

    public void printStatus(Cars cars) {
        cars.getCars().entrySet().stream()
                .forEach(entry -> {
                    String carName = entry.getKey();
                    Integer distance = entry.getValue();
                    System.out.println(carName + " : " + "-".repeat(distance));
                    System.out.println();
                });
    }
}
