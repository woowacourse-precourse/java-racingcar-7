package racingcar;

import static racingcar.Application.carMap;
import static racingcar.Application.len;

public class Print {

    // 전체 자동차 순회하기
    public static void output() {
        for (int o=0;o<len;o++) {
            printResult(o);
        }
    }

    // 각 자동차별 결과 출력하기
    public static void printResult(int num) {
        System.out.println(carMap[num][0] + " : " + carMap[num][1]);
    }
}
