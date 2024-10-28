package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerFinder {

    protected static List<String> findWinner(List<RacingCar> racingCars) {
        List<String> winners = new ArrayList<>();
        int maxDistance = -1;
        for (RacingCar racingCar : racingCars) {
            if (racingCar.getPosition() > maxDistance) {
                maxDistance = racingCar.getPosition();
                winners.clear();
            }
            if (racingCar.getPosition() == maxDistance) {
                winners.add(racingCar.getName());
            }
        }

        return winners;
    }
}
