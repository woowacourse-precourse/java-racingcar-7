package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private List<Car> cars;
    private int rounds;

    public GameManager(String[] carNames, int rounds) {
        cars = new ArrayList<>();
        this.rounds = rounds;

        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void startRace() {
        for (int idx = 0; idx < rounds; ++idx) {
            startRound();
            printRoundResult();
            System.out.println();
        }

        printWinner();
    }

    private void startRound() {
        for (Car car : cars) {
            car.Move();
        }
    }

    private void printRoundResult() {
        for (Car car : cars) {
            System.out.println(car.Result());
        }
    }

    private void printWinner() {
        int first = cars.stream()
                .mapToInt(Car::GetPosition)
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.GetPosition() == first) {
                winners.add(car.GetName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
