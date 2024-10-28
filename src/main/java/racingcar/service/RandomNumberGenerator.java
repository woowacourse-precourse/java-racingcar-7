package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    public int generate() {
        return Randoms.pickNumberInRange(0, 9); // 0부터 9까지의 정수 중 하나를 반환
    }
}
