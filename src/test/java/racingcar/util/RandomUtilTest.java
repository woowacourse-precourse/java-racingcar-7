package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RandomUtilTest {
    @Test
    void 랜덤_값_0과_9사이_추출() {
        assertThat(RandomUtil.pickRandom()).isBetween(0, 9);
    }
}
