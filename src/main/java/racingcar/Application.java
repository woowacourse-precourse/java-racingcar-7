package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String carsNameInput = Console.readLine();
        String chanceInput = Console.readLine();

        Map<String, Integer> carsInfo = new HashMap<>();
        for(String carName : carsNameInput.split(",")) {
            carsInfo.put(carName, 0);
        }

    }
}
