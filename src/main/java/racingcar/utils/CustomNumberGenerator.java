package racingcar.utils;


import camp.nextstep.edu.missionutils.Randoms;

public class CustomNumberGenerator implements NumberGenerator {
    public int generateInteger() {
        return generateRandomNumberInRange(0, 9);
    }

    public int generateRandomNumberInRange(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
