package racingcar.game;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;
import racingcar.generator.NumberGenerator;


public class RacingGame {
    private final NumberGenerator numberGenerator;

    public RacingGame(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<String> play(List<Car> cars, int round) {
        for (int count = 0; count < round; count++) {
            run(cars);
        }
        return getWinner(cars);
    }

    private void run(List<Car> cars) {
        for (Car car : cars) {
            car.move(generateNumber());
        }
        printRoundResult(cars);
    }

    private int generateNumber() {
        return numberGenerator.generate();
    }

    private void printRoundResult(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName()).append(" : ").append("-".repeat(car.getPosition())).append("\n");
        }
        System.out.println(sb);
    }

    private List<String> getWinner(List<Car> cars) {
        List<String> winner = new ArrayList<>();
        int max = getMaxPosition(cars);
        for (Car car : cars) {
            if (car.getPosition() == max) {
                winner.add(car.getName());
            }
        }
        return winner;
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }

}

