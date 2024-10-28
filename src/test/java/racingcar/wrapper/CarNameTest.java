package racingcar.wrapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun"})
    void 자동차_이름_생성_테스트(String name) {
        CarName carName = CarName.of(name);

        assertThat(carName.getName())
                .isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi123", "woni123", "jun123"})
    void 자동차_이름_5자_이상_예외_테스트(String name) {
        assertThatThrownBy(() -> CarName.of(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "   "})
    void 자동차_이름_1자_미만_예외_테스트(String name) {
        assertThatThrownBy(() -> CarName.of(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상이어야 합니다.");
    }

}
