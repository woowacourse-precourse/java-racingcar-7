package racingcar.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

class RandomUtilTest {

    @RepeatedTest(value = 10, name = "반복 검증 :: {currentRepetition}/{totalRepetitions}")
    void 무작위_값은_범위내_숫자만_추출한다() {
        // given
        int randomNumber = RandomUtil.generateRandomNumber();

        // when & then
        Assertions.assertTrue(randomNumber >= 0 && randomNumber <= 9);
    }
}