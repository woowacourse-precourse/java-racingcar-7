package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.RacingConstants.MAX_NUMBER;
import static racingcar.RacingConstants.MIN_NUMBER;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class NumberGeneratorTest {
    @DisplayName("객체 생성 시 주어진 범위 내의 숫자 1개가 생성된다")
    @RepeatedTest(100)
    void pickOne() {
        int actual = new NumberGenerator(MIN_NUMBER, MAX_NUMBER).pickOne();

        assertThat(actual).isBetween(MIN_NUMBER, MAX_NUMBER);
    }
}