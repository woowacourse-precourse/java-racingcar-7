package racingcar;

import static racingcar.Validator.validateCarNames;
import static racingcar.Validator.validateTryCount;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String carNames = InputManager.readCarNames();
        String tryCount = InputManager.readTryCount();

        validateCarNames(carNames);
        validateTryCount(tryCount);

       List<RacingCar> racingCarList = initRacingCarList(carNames);
       int maxRoundValue = initMaxRoundValue(tryCount);
       Race race = new Race(racingCarList, maxRoundValue);
       race.start();
    }

    static List<RacingCar> initRacingCarList(String carNames) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            RacingCar racingCar = new RacingCar(carName.strip());
            racingCarList.add(racingCar);
        }
        return racingCarList;
    }

    static int initMaxRoundValue(String tryCount) {
        return Integer.parseInt(tryCount);
    }

}
