package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.service.collection.RacingCar;

public class Find {

    public int FurthestNumber(RacingCar racingCar) {
        final List<String> allRacingCarName = racingCar.getAllRacingCarName();
        int max = 0;

        for (String eachRacingCar : allRacingCarName) {
            if (racingCar.getRacingCarPosition(eachRacingCar) > max) {
                max = racingCar.getRacingCarPosition(eachRacingCar);
            }
        }
        return max;
    }

    public List<String> Winners(RacingCar racingCar, int furthestNumber) {
        final List<String> winners = new ArrayList<>();
        final List<String> allRacingCarName = racingCar.getAllRacingCarName();

        for (String eachRacingCar : allRacingCarName) {
            if (racingCar.getRacingCarPosition(eachRacingCar) == furthestNumber) {
                winners.add(eachRacingCar);
            }
        }
        return winners;
    }
}
