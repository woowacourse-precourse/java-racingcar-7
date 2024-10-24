package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    @Test
    void 생성된_숫자가_0과_9_사이인지_테스트() {
        //given
        Generator randomGenerator = new RandomNumGenerator();

        //then
        for (int i = 0; i < 1000; i++) {
            Assertions.assertThat(randomGenerator.generate())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
        }
    }
}
