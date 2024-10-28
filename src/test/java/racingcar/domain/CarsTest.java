package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    void 자동차가_최소_경주_대수_이하일_때_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Cars.from(List.of(Car.from("우테코"))))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
