package racingcar;

import static racingcar.Car.makeCarList;
import static racingcar.Race.runRace;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        String[] carNames = Console.readLine().split(",");
        List<Car> raceCars = makeCarList(carNames);
        runRace(raceCars);
    }
}
