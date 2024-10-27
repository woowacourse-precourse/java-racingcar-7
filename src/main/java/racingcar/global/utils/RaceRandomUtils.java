package racingcar.global.utils;

import static racingcar.global.constants.RaceConfigValues.MAX_RANDOM_NUMBER;
import static racingcar.global.constants.RaceConfigValues.MIN_RANDOM_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceRandomUtils {
    private RaceRandomUtils() {
        // 인스턴스 생성 방지 (정적 메서드만 사용)
    }

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER.getValue(), MAX_RANDOM_NUMBER.getValue());
    }
}
