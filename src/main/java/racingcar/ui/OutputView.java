package racingcar.ui;

import racingcar.domain.car.Car;

import java.util.List;

public class OutputView implements UserOutput {

    public void printRaceStatus(List<Car> cars) {
        cars.forEach(car -> {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        });
        System.out.println();
    }

    // 우승자 출력
    public void printWinners(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }
}
