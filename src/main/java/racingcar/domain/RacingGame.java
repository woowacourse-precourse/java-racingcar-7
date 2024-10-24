package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void play(final int attempts) {
        StringBuilder raceResult = new StringBuilder();
        for (int i = 0; i < attempts; i++) {
            race();
            raceResult.append(getRaceStatus()).append("\n");
        }
        System.out.print(raceResult.toString());
        printWinners();
    }

    private void race(){
        for (final Car car : cars) {
            car.move();
        }
    }

    private String getRaceStatus() {
        StringBuilder status = new StringBuilder();
        for (final Car car : cars) {
            status.append(car.getName()).append(" : ").append("-".repeat(car.getPosition())).append("\n");
        }
        return status.toString();
    }

    void printWinners(){
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition) // 우승자의 위치와 동일한 자동차들
                .map(Car::getName)
                .toList();

        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}
