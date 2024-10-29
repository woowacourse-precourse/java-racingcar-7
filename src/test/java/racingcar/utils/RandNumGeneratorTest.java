package racingcar.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandNumGeneratorTest {

    @Test
    @DisplayName("메서드는 부울형인 참 또는 거짓 중 하나를 반환한다.")
    void methodReturnBoolean() {
        RandNumGenerator randNumGenerator = new RandNumGenerator();
        assertThat(randNumGenerator.isRandNumGreaterThanOrEqualToCriterion()).isInstanceOf(Boolean.class);
    }
}
