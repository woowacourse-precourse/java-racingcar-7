package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Name;

import java.util.ArrayList;
import java.util.List;

public class RaceController {
    private final List<Car> cars;
    private final int rounds;

    public RaceController(List<Name> names, int rounds) {
        this.cars = createCars(names);
        this.rounds = rounds;
    }

    private List<Car> createCars(List<Name> names) {
        List<Car> cars = new ArrayList<>();
        for (Name name : names) {
            cars.add(new Car(name.getName()));
        }
        return cars;
    }

    public void startRace() {
        System.out.println("실행 결과");
        for (int i = 0; i < rounds; i++) {
            playRound();
            printProgress();
        }
        printWinners();
    }

    private void playRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void printProgress() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private void printWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
