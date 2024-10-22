package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @Test
    void 정상적인_자동차_이름() {
        // given
        String carName = "pobi";
        CarName pobi = new CarName(carName);

        // then
        assertThat(pobi.getName()).isEqualTo("pobi");
    }

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(strings = {"", " "})
    void 예외_자동차_이름이_빈_값(String input) {
        // then
        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_자동차_이름_길이가_5를_초과() {
        // given
        String carName = "123456";
        int maxNameLength = 5;

        // then
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(carName.length()).isGreaterThan(maxNameLength);
    }
}