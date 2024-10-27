package racingcar.model;

import java.util.List;

public class Game {
    private final List<Car> cars;
    private int round;

    private Game(List<String> carNames, int round) {
        this.cars = carNames.stream()
                .map(Car::create)
                .toList();
        this.round = round;
    }

    public static Game start(List<String> carNames, int round) {
        return new Game(carNames, round);
    }

    public void play() {
        playARound();
        round--;
    }

    private void playARound() {
        for (Car car : cars) {
            move(car);
        }
    }

    private static void move(Car car) {
        if (CanMoveForward(car)) {
            car.moveForward();
        }
    }

    private static boolean CanMoveForward(Car car) {
        return car.pickRandomNumber() >= 4;
    }

    public List<String> findWinners() {
        return cars.stream()
                .filter(car -> car.getLocation() == findWinnerLocation())
                .map(Car::getName)
                .toList();
    }

    private int findWinnerLocation() {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);
    }

    public boolean isGameEnd() {
        if (isRoundZero()) {
            return true;
        }
        return false;
    }

    private boolean isRoundZero() {
        return round == 0;
    }

    public List<String> getStatus() {
        return cars.stream()
                .map(Car::getStatus)
                .toList();
    }
}
