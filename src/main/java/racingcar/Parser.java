package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    static List<RacingCar> parseRacingCarList(String carNames) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            RacingCar racingCar = new RacingCar(carName.strip());
            racingCarList.add(racingCar);
        }
        return racingCarList;
    }

    static int parseMaxRoundValue(String tryCount) {
        return Integer.parseInt(tryCount);
    }
}
