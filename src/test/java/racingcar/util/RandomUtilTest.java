package racingcar.util;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.util.RandomUtil.*;

import org.junit.jupiter.api.RepeatedTest;

class RandomUtilTest {

    @RepeatedTest(value = 10, name = "반복 검증 :: {currentRepetition}/{totalRepetitions}")
    void 무작위_값은_범위내_숫자만_추출한다() {
        // given
        int randomNumber = generateRandomNumber();

        // when & then
        assertTrue(randomNumber >= RANDOM_MIN_RANGE && randomNumber <= RANDOM_MAX_RANGE);
    }
}