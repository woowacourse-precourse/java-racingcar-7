package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars;
    private int turn;

    public RacingGame(List<Car> cars, int turn) {
        this.cars = cars;
        this.turn = turn;
    }

    public void start() {
        System.out.println("실행 결과");

        while (turn-- > 0) {
            cars.forEach(Car::randomMove);
            cars.forEach(Car::displayPosition);
            System.out.println();
        }

        System.out.println(displayWinners());
    }

    private String displayWinners() {
        List<Car> winners = calculateWinners();

        String result = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        return "최종 우승자 : " + result;
    }

    private List<Car> calculateWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());

        return winners;
    }
}
