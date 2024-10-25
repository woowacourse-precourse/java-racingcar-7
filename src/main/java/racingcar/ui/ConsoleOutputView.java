package racingcar.ui;

import racingcar.domain.car.Cars;

import java.util.List;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printRaceStatus(Cars cars) {
        cars.getCars().forEach(car -> {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        });
        System.out.println();
    }

    @Override
    public void printWinners(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }
}
