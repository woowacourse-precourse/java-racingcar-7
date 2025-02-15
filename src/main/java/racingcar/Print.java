package racingcar;

import static racingcar.Application.*;

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

    // 최종 우승자 출력하기
    public static void printWinner() {
        System.out.print(resultArr.get(0));
    }

    // 공동 우승자 출력하기
    public static void together() {
        for (int t=1;t<resultArr.size();t++) {
            System.out.print(", ");
            System.out.print(resultArr.get(t));
        }
    }
}
