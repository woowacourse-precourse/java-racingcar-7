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

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
