package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingTest {

    @Test
    void validateTest_whenCarNotExist_throwException() {
        List<Car> cars = Collections.emptyList();

        assertThatThrownBy(() -> new Racing(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차는 1대 이상 존재해야 합니다");
    }
}
