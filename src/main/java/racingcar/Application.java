package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        List<String> carInput = List.of(Console.readLine().split(","));

        Map<String, Integer> cars = new HashMap<>();
        for(String car : carInput) {
            cars.put(car, 0);
        }

    }
}
