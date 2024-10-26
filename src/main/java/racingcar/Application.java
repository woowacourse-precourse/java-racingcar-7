package racingcar;

import static racingcar.Car.makeCarList;
import static racingcar.Race.runRace;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        List<String> carNames = List.of(Console.readLine().split(","));
        checkInput(carNames);
        List<Car> raceCars = makeCarList(carNames);
        runRace(raceCars);
    }

    public static void checkInput(List<String> input) {
        for (String carName : input) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }
}
