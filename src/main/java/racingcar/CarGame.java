package racingcar;

import racingcar.car.Car;
import racingcar.decider.Decider;

import java.util.List;

public class CarGame {
    private final int numberOfTurn;
    private List<Car> entryCars;
    private Decider decider;

    public CarGame(int numberOfTurn, List<Car> entryCars, Decider decider) {
        this.numberOfTurn = numberOfTurn;
        this.entryCars = entryCars;
        this.decider = decider;
    }
    private void moveCars() {
        for (Car car: entryCars) {
            boolean move = decider.decideMoveOrNot();
            if (move) {
                car.forward();
            }
        }
    }

    private void printCars() {
        for (Car car: entryCars) {
            System.out.printf("%s : ", car.getName());
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    private List<String> getWinners() {
        int maxPosition = entryCars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return entryCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    public List<String> play() {
        for (int i = 0 ; i < numberOfTurn; i++) {
            moveCars();
            printCars();
        }
        return getWinners();
    }
}
