package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RandomTest {
    private static final int MINIMUM_NUMBER_RANGE = 0;
    private static final int MAXIMUM_NUMBER_RANGE = 9;
    private final NumberGenerator numberGenerator = new Random();

    @DisplayName("0~9 사이의 랜덤 숫자를 반환한다.")
    @RepeatedTest(100)
    void testPickNumberWithinRange() {
        // when
        int randomNumber = numberGenerator.pickNumber();

        // then
        assertThat(randomNumber)
                .isGreaterThanOrEqualTo(MINIMUM_NUMBER_RANGE)
                .isLessThanOrEqualTo(MAXIMUM_NUMBER_RANGE);
    }
}