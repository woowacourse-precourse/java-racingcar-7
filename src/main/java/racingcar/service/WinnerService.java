package racingcar.service;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

public class WinnerService {

    public static void printWinner(Map<String, Integer> racingCar) {
        System.out.print("최종 우승자 : ");
        Integer maxValue = Collections.max(racingCar.values());
        for (Entry<String, Integer> entry : racingCar.entrySet()) {
            String carName = entry.getKey();
            Integer go = entry.getValue();

            if(go == maxValue) {
                System.out.print(carName);
            }
        }
    }
}
