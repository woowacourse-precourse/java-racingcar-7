package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {
        // 유틸 클래스로만 활용하기 위해, 인스턴스 생성을 방지
    }

    public static int pickNumberInRange(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }
}
