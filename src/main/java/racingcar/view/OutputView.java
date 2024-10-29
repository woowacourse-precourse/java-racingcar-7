package racingcar.view;

import racingcar.domain.Car;
import java.util.List;

public class OutputView {
    public void printGameStart() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(List<Car> cars) {
        cars.forEach(this::printCarStatus);
        System.out.println();
    }

    private void printCarStatus(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}