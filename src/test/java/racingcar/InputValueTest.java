package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.ValidateCarNames;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class InputValueTest {
    private static final String CAR_NAMES_BLANK = "";
    private static final String CAR_NAMES_WHITE = " ";
    private static final String CAR_NAMES_NULL = null;

    @DisplayName("경주할 자동차들이 빈 문자열이면 예외 발생")
    @Test
    void ThrowExceptionIfCarNamesBlank() {
        // given
        ValidateCarNames validateCarNames = new ValidateCarNames();

        // when
        Throwable thrown = catchThrowable(() -> {
            validateCarNames.isBlank(CAR_NAMES_BLANK);
        });

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 빈 값이 될 수 없습니다.");
    }

    @DisplayName("경주할 자동차들이 공백값이면 예외 발생")
    @Test
    void ThrowExceptionIfCarNamesBlankWhite() {
        // given
        ValidateCarNames validateCarNames = new ValidateCarNames();

        // when
        Throwable thrown = catchThrowable(() -> {
            validateCarNames.isBlank(CAR_NAMES_WHITE);
        });

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 빈 값이 될 수 없습니다.");
    }

    @DisplayName("경주할 자동차들이 null이면 예외 발생")
    @Test
    public void ThrowExceptionIfCarNamesNULL() {
        // given
        ValidateCarNames validateCarNames = new ValidateCarNames();

        // when
        Throwable thrown = catchThrowable(() -> {
            validateCarNames.isNull(CAR_NAMES_NULL);
        });

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 null이 될 수 없습니다.");
    }
}
