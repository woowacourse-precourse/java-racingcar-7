package racingcar.car.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);  // 0에서 9 사이의 랜덤 숫자 생성
    }
}
