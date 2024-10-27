package racingcar.view;

import java.util.HashMap;
import racingcar.message.RunMessage;

public class OutView {

    public static void printRacingResult(HashMap<String, Integer> cars) {
        for (String car : cars.keySet()) {
            System.out.printf(RunMessage.PRINT_CAR.getMessage(), car);
            System.out.println(String.valueOf('-').repeat(cars.get(car)));
        }
        System.out.println();
    }
}
