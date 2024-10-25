package racingcar.car.util;

import camp.nextstep.edu.missionutils.Randoms;

// 0부터 9까지 랜덤 숫자를 생성하는 유틸리티 클래스
public class RandomNumberGenerator {
    public int generateRandomNumber(int min, int max) {
        return Randoms.pickNumberInRange(0, 9);  // 0에서 9 사이의 랜덤 숫자 생성
    }
}
