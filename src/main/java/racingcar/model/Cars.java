package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.validator.Validator;

public class Cars {
    static Map<String, String> cars = new LinkedHashMap<>();

    public static void register(List<String> names) {
        for (String name : names) {
            Validator.validateCarName(name);
            cars.put(name, "");
        }
    }

    public static Map<String, String> moveForward() {
        for (String key : cars.keySet()) {
            int random = Randoms.pickNumberInRange(0, 9);
            if (random >= 4) {
                cars.put(key, cars.get(key) + "-");
            }
        }
        return cars;
    }

    public static List<String> findWinner() {
        List<String> winnerList = new ArrayList<>();
        int max = 0;
        for (String key : cars.keySet()) {
            if (cars.get(key).length() > max) {
                max = cars.get(key).length();
                winnerList = new ArrayList<>();
                winnerList.add(key);
                continue;
            }
            if (cars.get(key).length() == max) {
                winnerList.add(key);
            }
        }
        return winnerList;
    }
}