package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class Application {
    static Map<String, Integer> car = new HashMap<>();

    public static int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static void moveOrStop(String carName, int randomNumber) {
        if (randomNumber >= 4) {
            car.put(carName, car.get(carName)+1);
        }
    }

    public static void main(String[] args) {

    }
}
