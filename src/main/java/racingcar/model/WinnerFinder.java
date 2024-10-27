package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class WinnerFinder {
    RacingCarManager racingCarManager;

    public WinnerFinder(RacingCarManager racingCarManager) {
        this.racingCarManager = racingCarManager;
    }

    public String getWinner() {
        int maxScore = findMaxScore(racingCarManager.getRacingCarList());
        List<String> winners = addWinners(racingCarManager.getRacingCarList(), maxScore);
        return String.join(", ", winners);
    }

    private int findMaxScore(List<RacingCar> cars) {
        int maxScore = 0;
        for (RacingCar car : cars) {
            if (car.getLocation() > maxScore) {
                maxScore = car.getLocation();
            }
        }
        return maxScore;
    }

    private List<String> addWinners(List<RacingCar> cars, int maxScore) {
        List<String> winners = new ArrayList<>();
        for (RacingCar car : cars) {
            if (car.getLocation() == maxScore) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }
}
