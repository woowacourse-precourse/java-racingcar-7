package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.ValidateCarNames;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;

public class InputValueTest {
    private static final String CAR_NAMES_BLANK = "";

    @DisplayName("경주할 자동차들이 빈 문자열이면 예외 발생")
    @Test
    void ThrowExceptionIfCarNameBlank() {
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

}
