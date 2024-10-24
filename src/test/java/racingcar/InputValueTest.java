package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;

public class InputValueTest {
    private static final String CAR_NAME_BLANK = "";

    @DisplayName("자동차 이름이 빈 값이면 예외 발생")
    @Test
    void ThrowExceptionIfCarNameBlank() {
        // given
        String carName = CAR_NAME_BLANK;
        ValidateCarName validateCarName = new valicateCarName();

        // when
        Throwable thrown = catchThrowable(() -> {
            validateCarName.isBlank(carName);
        });

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 빈 값이 될 수 없습니다.");
    }

}
