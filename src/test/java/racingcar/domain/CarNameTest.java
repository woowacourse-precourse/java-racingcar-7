package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.constants.ErrorMessage.CAR_NAME_LENGTH_EXCEEDED;
import static racingcar.exception.constants.ErrorMessage.EMPTY_CAR_NAME_NOT_ALLOWED;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.RacingCarException;

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
    @NullSource
    @ValueSource(strings = {"", " "})
    void 예외_자동차_이름이_빈_값(final String input) {
        // then
        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(EMPTY_CAR_NAME_NOT_ALLOWED.getMessage());
    }

    @Test
    void 예외_자동차_이름_길이가_5를_초과() {
        // given
        String carName = "123456";
        int maxNameLength = 5;

        // then
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_LENGTH_EXCEEDED.getMessage());
        assertThat(carName.length()).isGreaterThan(maxNameLength);
    }
}