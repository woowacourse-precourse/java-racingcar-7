package racingcar.view;

import racingcar.model.Car;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printRaceResultStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRaceRound(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }

    public void printErrorMessage(String message) {
        System.out.println("오류: " + message);
    }
}
