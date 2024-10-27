package racingcar;

import static racingcar.Parser.parseMaxRoundValue;
import static racingcar.Parser.parseRacingCarList;
import static racingcar.Validator.validateCarNames;
import static racingcar.Validator.validateTryCount;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String carNames = InputManager.readCarNames();
        String tryCount = InputManager.readTryCount();

        validateCarNames(carNames);
        validateTryCount(tryCount);

       List<RacingCar> racingCarList = parseRacingCarList(carNames);
       int maxRoundValue = parseMaxRoundValue(tryCount);
       Race race = new Race(racingCarList, maxRoundValue);
       race.start();
    }
}
