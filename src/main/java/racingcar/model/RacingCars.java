package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> cars;

    public RacingCars(List<RacingCar> cars) {
        this.cars = new ArrayList<>(cars);
    }
    public void moveCars() {
        for (RacingCar car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.move(randomValue);
        }
    }
    public List<String> getResults() {
        List<String> results = new ArrayList<>();
        for (RacingCar car : cars) {
            results.add(car.toString());
        }
        return results;
    }
    public List<RacingCar> getCarsByScore(int score) {
        List<RacingCar> collectedCars = new ArrayList<>();
        for (RacingCar car : cars) {
            if (car.getScore().getValue() == score) {
                collectedCars.add(car);
            }
        }
        return collectedCars;
    }
    public int getMaxScore() {
        int maxScore = -1;
        for (RacingCar car: cars) {
            if (car.getScore().getValue() > maxScore) {
                maxScore = car.getScore().getValue();
            }
        }
        return maxScore;
    }
    public String getWinners() {
        int maxScore = getMaxScore();
        List<RacingCar> collectedCars = getCarsByScore(maxScore);
        StringBuilder winners = new StringBuilder();
        for (RacingCar car : collectedCars) {
            if (winners.length() > 0) {
                winners.append(", ");
            }
            winners.append(car.getName());
        }
        return winners.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String result : getResults()) {
            sb.append(result).append("\n");
        }
        return sb.toString();
    }
}
