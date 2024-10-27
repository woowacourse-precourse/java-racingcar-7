package racingcar.global.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceRandomUtils {
    private RaceRandomUtils() {
        // 인스턴스 생성 방지 (정적 메서드만 사용)
    }

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
