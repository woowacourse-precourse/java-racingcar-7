package racingcar.object.value;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarNameTest {

    private static final Class<IllegalArgumentException> COMMON_EXCEPTION = IllegalArgumentException.class;

    @Test
    void 자동차_이름이_null_or_emptyString이면_예외발생() {
        assertThatThrownBy(() -> new CarName(null))
                .isInstanceOf(COMMON_EXCEPTION);

        assertThatThrownBy(() -> new CarName(""))
                .isInstanceOf(COMMON_EXCEPTION);
    }

}