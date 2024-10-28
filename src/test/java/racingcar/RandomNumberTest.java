package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomNumberTest {
    RandomNumber randomNumber;

    @BeforeEach
    void setup() {
        randomNumber = new RandomNumber();
    }

    @Test
    @RepeatedTest(5)
    void 무작위_값_음수_테스트() {
        int result = randomNumber.make();
        assertThat(result).isGreaterThan(-1);
    }

    @Test
    @RepeatedTest(5)
    void 무작위_값_9이상_테스트() {
        int result = randomNumber.make();
        assertThat(result).isLessThan(10);
    }

    @Test
    void 무작위_값_전진_4이상_범위_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    boolean result = randomNumber.pick();
                    assertTrue(result);
                },
                Contants.COMPARISON_VALUE, Contants.COMPARISON_VALUE + 1
        );
    }

    @Test
    void 무작위_값_전진_4미만_범위_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    boolean result = randomNumber.pick();
                    assertFalse(result);
                },
                Contants.COMPARISON_VALUE - 1
        );
    }
}
