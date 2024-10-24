package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;


public class CarRace {

    public void play(String names, String count) {
        HashMap<String, Integer> cars = getCar(names);
        int tryCount = getCount(count);
        for (int round = 0; round < tryCount; round++) {
            for (String car : cars.keySet()) {
                int random = random();
                if (random >= 4) {
                    cars.put(car, cars.get(car) + 1);
                }
            }
        }
    }

    public int random() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private HashMap<String, Integer> getCar(String input) {
        try {
            String[] cars = input.split(",");

            HashMap<String, Integer> carMap = new HashMap<>();
            for (String car : cars) {
                carMap.put(car, 0);
            }

            return carMap;
        } catch (Exception e) {
            throw new IllegalArgumentException("쉼표(,)로 구분된 자동차 이름을 입력해주세요", e);
        }
    }

    private int getCount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1이상의 숫자를 입력해주세요", e);
        }
    }
}

