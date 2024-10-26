package racingcar.view;

import java.util.Map;

public class OutputView {

    public static void print(Map<String, Integer> racingCar) {
        for (String carName : racingCar.keySet()) {
            int go = racingCar.get(carName);

            System.out.println(carName + " : " + "-".repeat(go) );
        }
        System.out.println();
    }
}
