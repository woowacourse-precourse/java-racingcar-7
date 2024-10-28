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

    protected void assignRandomValue(Car car) {
        int randomValue = Randoms.pickNumberInRange(MIN, MAX);
        car.setRandomValue(randomValue);
        updateScoreIfNeeded(car, randomValue);
    }

    public void updateScoreIfNeeded(Car car, int randomValue) {
        if (randomValue >= 4) {
            incrementScore(car);
        }
        System.out.println(car.getName() + " : " + carView.generateScoreDisplay(car.getScore()));
    }

    public void incrementScore(Car car) {
        car.setScore(car.getScore() + 1);

    }

    public List<Car> findWinners(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        int maxScore = findMaxScore(cars);

        for (Car car : cars) {
            if (car.getScore() == maxScore) {
                winners.add(car);
            }
        }

        return winners;
    }

    private int findMaxScore(List<Car> cars) {
        int maxScore = Integer.MIN_VALUE;
        for (Car car : cars) {
            maxScore = Math.max(maxScore, car.getScore());
        }
        return maxScore;
    }
}
