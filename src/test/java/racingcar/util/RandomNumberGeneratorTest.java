package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {
    public static final int MIN_NUM = 0;
    public static final int MAX_NUM = 9;

    @Test
    void 범위에_맞는_숫자_생성() {
        NumberGenerator randomNumberGenerator = RandomNumberGenerator.getInstance();
        int random_Number = randomNumberGenerator.generateNumber(MIN_NUM, MAX_NUM);
        assertThat(random_Number).isBetween(MIN_NUM, MAX_NUM);
    }

}
