package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class ExceptionCheckTest {
    @Test
    void lengthExceedFiveTest() {
        assertThatThrownBy(() -> ExceptionCheck.lengthExceedFive(List.of("python")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void intRangeAndNotNegativeTest() {
        assertThatThrownBy(() -> ExceptionCheck.intRangeAndNotNegative("notNumber"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> ExceptionCheck.intRangeAndNotNegative("2500000000"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> ExceptionCheck.intRangeAndNotNegative("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}