package racingcar;

import static racingcar.Validator.validateCarNames;
import static racingcar.Validator.validateTryCount;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String carNames = readCarNames();
        String tryCount = readTryCount();

        validateCarNames(carNames);
        validateTryCount(tryCount);

       List<RacingCar> racingCarList = initRacingCarList(carNames);
       int maxRoundValue = Integer.parseInt(tryCount);
       Race race = new Race(racingCarList, maxRoundValue);
       race.start();
    }

    static List<RacingCar> initRacingCarList(String carNames) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            RacingCar racingCar = new RacingCar(carName);
            racingCarList.add(racingCar);
        }
        return racingCarList;
    }

    static String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    static String readTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }
}
