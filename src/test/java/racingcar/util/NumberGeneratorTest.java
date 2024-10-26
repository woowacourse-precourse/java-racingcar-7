package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {
    public static final int MIN_NUM = 0;
    public static final int MAX_NUM = 9;

    @Test
    void 범위에_맞는_숫자_생성() {
        NumberGenerator numberGenerator = NumberGenerator.getInstance();
        int random_Number = numberGenerator.generateNumber(MIN_NUM, MAX_NUM);
        assertThat(random_Number).isBetween(MIN_NUM, MAX_NUM);
    }

}
