package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    public void printRaceStatus(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.getName() + " : " + "-".repeat(car.getPosition())));
        System.out.println();
    }

    public void printFinalWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
