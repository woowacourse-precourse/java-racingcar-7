package racingcar;

import static racingcar.Application.*;

public class Result {

    // 가장 멀리 간 자동차의 길이를 구할 변수 선언하기
    public static int winLength = 0;

    // 전체 자동차를 순회하며 최대 길이 찾기
    public static void findMax() {
        for (int f=0;f<len;f++) {
            exam(f);
        }
    }

    // 결과값의 길이가 우승자의 길이보다 크면 우승자의 길이 갱신
    public static void exam(int num) {
        if (carMap[num][1].length()>winLength) {
            winLength = carMap[num][1].length();
        }
    }

    // 전체 자동차를 순회하며 최대 길이 찾기
    public static void judge() {
        for (int j=0;j<len;j++) {
            add(j);
        }
    }

    // 자동차의 결과 값이 최대 길이이면 배열에 넣기
    public static void add(int num) {
        if (carMap[num][1].length()==winLength) {
            resultArr.add(carMap[num][0]);
        }
    }
}
