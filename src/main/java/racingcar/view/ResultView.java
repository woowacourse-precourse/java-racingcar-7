package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {

    public static void printRaceStatus(List<Car> cars) {
        StringBuilder raceResult = new StringBuilder();
        for (Car car : cars) {
            raceResult.append(car.getName()).append(" : ").append("-".repeat(car.getPosition())).append("\n");
        }
        raceResult.append("\n");
        System.out.print(raceResult);
    }

    public static void printWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();

        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}
