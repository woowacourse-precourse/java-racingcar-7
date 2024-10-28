package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import static racingcar.Application.carMap;
import static racingcar.Application.len;

public class Race {

    // 0~9사이의 랜덤 숫자 반환하기
    public static int pickNumber() {
        return Randoms.pickNumberInRange(0,9);
    }

    // 그 랜덤 숫자가 4 이상인지 판단하기
    public static boolean random () {
        int K = pickNumber();
        return over4(K);
    }

    // 4 이상이면 true 아니면 false 반환하기
    public static boolean over4 (int num) {
        if (num>=4) {
            return true;
        }
        return false;
    }

    // 각 자동차별로 앞으로 움직이기
    public static void move () {
        for (int m=0;m<len;m++) {
            forward(m);
        }
    }

    // 4 이상일 경우 결과값에 "-"추가하기
    public static void forward(int num) {
        if (random()) {
            carMap[num][1]+="-";
        }
    }

}
