package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = {" pobi", "pobi ", "po bi"})
    void 자동차_이름에_스페이스가_존재할_때_예외_발생(String carName) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> CarName.from(carName))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름이_없_때_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> CarName.from(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
