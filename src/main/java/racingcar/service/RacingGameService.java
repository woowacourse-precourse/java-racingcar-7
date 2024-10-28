package racingcar.service;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingGameService {
    private final List<Car> cars = new ArrayList<>();
    private int rounds;

    public void createCars(String input) {
        String[] carNames = input.split(",");

        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
    }

    public void setRounds(String input) {
        this.rounds = Integer.parseInt(input);
    }

    public void startRace() {
        for (int i = 0; i < rounds; i++){
            for (Car car : cars) {
                car.move();
            }
            printCurrentPostions();
            System.out.println();
        }
    }

    private void printCurrentPostions() {
        for(Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    private void announceWinners() {
        List<Car> winners = findWinners();
        String winnerNames = winners.stream()
                .map(Car::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
        System.out.println("최종 우승자 : " + winnerNames);
    }

    private List<Car> findWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }
}
