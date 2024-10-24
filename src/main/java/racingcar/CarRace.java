package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;


public class CarRace {

    private static final int MOVING_FORWARD = 4;
    private static final int NAME_LENGTH = 5;

    public String play(String names, String count) {
        HashMap<String, Integer> cars = getCar(names);
        int tryCount = getCount(count);
        for (int round = 0; round < tryCount; round++) {
            move(cars);
            printRoundResult(cars);
        }
        return getWinner(cars);
    }

    private HashMap<String, Integer> getCar(String input) {
        try {
            String[] cars = input.split(",");

            HashMap<String, Integer> carMap = new HashMap<>();
            for (String car : cars) {
                if (car.length() >= NAME_LENGTH) {
                    throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요");
                }
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

    private void move(HashMap<String, Integer> cars) {
        for (String car : cars.keySet()) {
            int random = random();
            if (random >= MOVING_FORWARD) {
                cars.put(car, cars.get(car) + 1);
            }
        }
    }

    private int random() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void printRoundResult(HashMap<String, Integer> cars) {
        StringBuilder sb = new StringBuilder();
        for (String car : cars.keySet()) {
            sb.append(car).append(" : ").append("-".repeat(cars.get(car))).append("\n");
        }
        System.out.println(sb);
    }

    private String getWinner(HashMap<String, Integer> cars) {
        int max = maxDistance(cars);
        StringBuilder sb = new StringBuilder();
        for (String car : cars.keySet()) {
            if (cars.get(car) == max) {
                sb.append(car).append(",");
            }
        }
        return sb.deleteCharAt(sb.length() - 1).toString();

    }

    private int maxDistance(HashMap<String, Integer> cars) {
        return cars.values().stream().max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("자동차가 없습니다"));
    }
}

