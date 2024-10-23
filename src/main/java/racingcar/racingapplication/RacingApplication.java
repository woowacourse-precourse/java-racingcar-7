package racingcar.racingapplication;

import java.util.List;
import racingcar.domain.Cars;

public class RacingApplication {

    public static List<Cars> race(int gameNumber, List<Cars> allCars) {
        if (gameNumber == 0) {
            return allCars;
        }
        Cars nextCars = allCars.getLast().eachGame();
        allCars.add(nextCars);
        return race(gameNumber - 1, allCars);
    }
}
