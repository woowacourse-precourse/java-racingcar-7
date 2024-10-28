package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import racingcar.Message.ErrorMessage;
import racingcar.Validator.CarsValidator;

class CarsTest extends NsTest {
    @Test
    void 중복_이름_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car,car"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.ERROR_MESSAGE_DUPLICATE_NAME)
        );
    }

    @Test
    void 자동차목록_null_검증() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> CarsValidator.validate(null))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.ERROR_MESSAGE_NO_CARS)
        );
    }

    @Test
    void 자동차목록_빈리스트_검증() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> CarsValidator.validate(Arrays.asList()))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.ERROR_MESSAGE_NO_CARS)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
