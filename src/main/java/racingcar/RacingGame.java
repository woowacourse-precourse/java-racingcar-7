package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final int attempts;

    public RacingGame(String carNameInput, int attempts) {
        this.cars = createCars(carNameInput);
        this.attempts = attempts;
    }

    private List<Car> createCars(String carNameInput) {
        List<String> carNames = List.of(carNameInput.split(","));
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void play() {
        System.out.println("실행 결과");
        for (int i = 0; i < attempts; i++) {
            playOneRound();
            System.out.println();
        }
    }

    private void playOneRound() {
        for (Car car : cars) {
            car.move();
            System.out.println(car.displayPosition());
        }
    }

    public void printWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();

        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
