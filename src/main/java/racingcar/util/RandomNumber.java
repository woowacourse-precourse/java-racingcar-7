package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private static final int startInclusive = 0;
    private static final int endInclusive = 9;

    //TODO: 랜덤값 생성
    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
