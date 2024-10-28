package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Stadium {

    private final List<Car> cars;

    public Stadium(List<String> carNames) {
        this.cars = createCars(carNames);
    }

    public List<String> updateCarPositions() {
        List<String> scores = new ArrayList<>();
        for (Car car : cars) {
            car.moveIfPossible(Randoms.pickNumberInRange(0, 9));
            scores.add(car.currentScore());
        }
        return scores;
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maxNum = findMaxScore();

        for (Car car : cars) {
            if (car.isMoveCountHigher(maxNum)) {
                winners.add(car.getWinner());
            }
        }

        return winners;
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream().map(Car::new).toList();
    }

    private int findMaxScore() {
        int maxScore = 0;
        for (Car car : cars) {
            if (car.isMoveCountHigher(maxScore)) {
                maxScore = car.compareScore(maxScore);
            }
        }
        return maxScore;
    }

}
