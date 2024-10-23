package racingcar.io;

import racingcar.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputHandler {

    public void showGameStartComment() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void showTryCountComment() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private void showWinners(List<Car> cars) {
        String carsName = generateWinnerCarsName(cars);
        System.out.printf("최종 우승자 : %s", carsName);
    }

    private String generateWinnerCarsName(List<Car> cars) {
        return cars.stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));
    }

}
