package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class IntegrationTests extends NsTest {

    @ParameterizedTest
    @DisplayName("[에러] 자동차 입력이 공백인 경우")
    @ValueSource(strings = {" ", "  ", "\n", "\t"})
    public void error_carInputBlank(String carInput) {
        String roundInput = "5";

        Throwable throwable = catchThrowable(
                () -> {
                    run(carInput, roundInput);
                }
        );

        assertThat(throwable)
                .hasMessageContaining(ErrorMessage.CAR_INPUT_EMPTY.getMessage());
    }

    @ParameterizedTest
    @DisplayName("[에러] 자동차 이름이 5자 초과인 경우")
    @ValueSource(strings = {"abcdef", "abcdefg", "gana,abcdef", "abcdefg,gana"})
    public void error_carNameOverLimit(String carInput) {
        String roundInput = "5";

        Throwable throwable = catchThrowable(
                () -> {
                    run(carInput, roundInput);
                }
        );

        assertThat(throwable)
                .hasMessageContaining(ErrorMessage.CAR_NAME_LENGTH_OVER.getMessage());
    }

    @ParameterizedTest
    @DisplayName("[에러] 라운드 입력이 공백인 경우")
    @ValueSource(strings = {" ", "  ", "\n", "\t"})
    public void error_roundInputEmpty(String roundInput) {
        String carInput = "gana,dara,maru";

        Throwable throwable = catchThrowable(
                () -> {
                    run(carInput, roundInput);
                }
        );

        assertThat(throwable)
                .hasMessageContaining(ErrorMessage.ROUND_INPUT_EMPTY.getMessage());
    }

    @ParameterizedTest
    @DisplayName("[에러] 라운드 입력이 숫자가 아닌 경우")
    @ValueSource(strings = {"g", "dd", "]", ";", "/"})
    public void error_roundInputNotNumber(String roundInput) {
        String carInput = "gana,dara,maru";

        Throwable throwable = catchThrowable(
                () -> {
                    run(carInput, roundInput);
                }
        );

        assertThat(throwable)
                .hasMessageContaining(ErrorMessage.ROUND_INPUT_TYPE_NOT_MATCH.getMessage());
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
