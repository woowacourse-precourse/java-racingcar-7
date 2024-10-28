package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private int repeatCount;
    private List<Car> cars;

    public Game(int repeatCount, List<Car> cars) {
        this.repeatCount = repeatCount;
        this.cars = cars;
    }

    public void playAllRounds(CareTaker careTaker) {
        for (int i = 0; i < repeatCount; i++) {
            careTaker.add(playRound());
        }
    }

    public List<Car> getWinner() {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }

    private GameMemento playRound() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            tryToMoveCar(randomValue, car);
        }
        return saveGame();
    }

    private void tryToMoveCar(int randomValue, Car car) {
        if (canCarMove(randomValue)) {
            car.move();
        }
    }

    private boolean canCarMove(int randomValue) {
        return randomValue >= 4;
    }

    private GameMemento saveGame() {
        List<Car> clonedCars = cars.stream()
                .map(Car::clone)
                .toList();
        return new GameMemento(clonedCars);
    }
}
