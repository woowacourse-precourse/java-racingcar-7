package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public record RacingGame(List<Car> cars, int rounds) {
    public void startRace() {
        System.out.println("실행 결과");
        for (int i = 0; i < rounds; i++) {
            for (Car car : cars) {
                car.move();
            }
            printRoundResults();
        }
    }

    private void printRoundResults() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printFinalResults() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
