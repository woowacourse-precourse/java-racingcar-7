package racingcar;

import java.util.HashMap;

import camp.nextstep.edu.missionutils.*;

public class Racingcar {
    // 주어진 횟수 동안 n대 자동차는 전진 or 멈춤
    public static HashMap<String, Integer> racing(int nums, HashMap<String, Integer> cars) {

        if (nums < 1){
            throw new IllegalArgumentException("시도 횟수가 너무 적습니다.");
        }

        for (int i = 0; i < nums; i++) {
            // 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우
            for (String s : cars.keySet()) {
                int random_num = Randoms.pickNumberInRange(0, 9);
                if (random_num >= 4) {
                    cars.put(s, cars.get(s) + 1);
                }
            }
            // 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력
            print_racing(cars);
        }

        return cars;
    }

    // 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력
    public static void print_racing(HashMap<String, Integer> cars) {
        for (String s : cars.keySet()) {
            System.out.println(s + " : " + "-".repeat(cars.get(s)));
        }
    }

    // 자동차 이름은 쉼표(,)를 기준으로 구분
    public static HashMap<String, Integer> cars_names(String names) {
        HashMap<String, Integer> cars = new HashMap<>();

        String[] name = names.split(",");

        for (String s : name) {
            // 이름은 5글자 이하. 예외처리
            if (s.length() > 5) {
                throw new IllegalArgumentException("이름이 너무 깁니다.");
            }
            cars.put(s, 0);
        }

        return cars;
    }
}
