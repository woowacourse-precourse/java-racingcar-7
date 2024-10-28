package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.Utils.*;

public class Application {
    public static void main(String[] args) {
        String[] carNames = getNamesFromString(readLine());
        int tryCount = getTryCountFromString(readLine());

        List<Vehicle> vehicles = new ArrayList<>(carNames.length);
        for (String carName : carNames) {
            vehicles.add(new Car(carName, 0));
        }
    }
}
