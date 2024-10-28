package service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import model.Car;
import view.CarView;

public class CarService {
    private static final int MIN = 1;
    private static final int MAX = 10;
    private final CarView carView = new CarView();

    public void assignRandomValueToAllCars(List<Car> cars) {
        for (Car car : cars) {
            assignRandomValue(car);
        }
    }

    public void assignRandomValue(Car car) {
        int randomValue = Randoms.pickNumberInRange(MIN, MAX);
        car.evaluateScoreBasedOnRandomValue(randomValue);
    }


    public List<Car> findWinners(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        int maxScore = findMaxScore(cars);

        for (Car car : cars) {
            if (car.determineWinners(maxScore)) {
                winners.add(car);
            }
        }

        return winners;
    }

    private int findMaxScore(List<Car> cars) {
        int maxScore = Integer.MIN_VALUE;
        for (Car car : cars) {
            maxScore = car.compareScore(maxScore); // 점수를 비교하여 maxScore 업데이트
        }
        return maxScore;
    }
}
