package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.NoSuchElementException;

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Racing {
    // 랜덤 숫자 생성
    // 4 이상일 경우 true, 미만일 경우 false
    public static Boolean RandomNum() {
        int Random = Randoms.pickNumberInRange(0, 9);

        if (Random >= 4) {
            return true;
        }
        return false;
    }

    // 각 자동차 이동
    // 이동은 RandomNum 함수의 결과에 따라 결정
    public static void MoveForward(Map<String, Integer> carMap, String car) {
        if (RandomNum()) {
            carMap.put(car, carMap.get(car) + 1);
        }
    }

    // 모든 자동차 1회 이동
    // 이동 결과 출력함수 포함
    public static void Racing(Map<String, Integer> carMap, String[] cars) {
        for (String car : cars) {
            MoveForward(carMap, car);
            System.out.print(car + " : ");

            int count = carMap.get(car);
            for (int i=0; i<count; i++) {
                System.out.print('-');
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void Winner(Map<String, Integer> carMap, String[] cars) {
        int max = Collections.max(carMap.values());
        List<String> winners = new ArrayList<>();

        for (String car : cars) {
            if (carMap.get(car) == max) {
                winners.add(car);
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}