package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Car> cars;
    private final int turns;

    public Game(List<Car> cars, int turns) {
        this.cars = cars;
        this.turns = turns;
    }

    public void play() {
        System.out.println("\n실행 결과");
        int remainingTurns = turns;

        while (remainingTurns-- > 0) {
            playTurn();
            System.out.println();
        }
    }

    private void playTurn() {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) > 3) {
                car.increaseScore();
            }
            System.out.printf("%s : %s%n", car.getName(), "-".repeat(car.getScore()));
        }
    }

    public List<String> getWinners() {
        int maxScore = cars.stream()
                .mapToInt(Car::getScore)
                .max().orElse(0);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getScore() == maxScore) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
