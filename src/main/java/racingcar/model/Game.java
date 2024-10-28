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

    private GameMemento playRound() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (canCarMove(randomValue)) {
                car.move();
            }
        }
        return saveGame();
    }

    private GameMemento saveGame() {
        List<Car> clonedCars = cars.stream()
                .map(Car::clone)
                .collect(Collectors.toList());
        return new GameMemento(clonedCars);
    }

    private boolean canCarMove(int randomValue) {
        return randomValue >= 4;
    }
}
