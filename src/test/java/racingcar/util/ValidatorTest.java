package racingcar.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static racingcar.constant.ErrorMessage.*;

public class ValidatorTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    @DisplayName("자동차의 이름이 6자 이상인 경우 예외가 발생한다")
    void 자동차_이름_입력_테스트1() throws Exception {
        //given
        String carNames = "abc,abcd,abcde,abcdef";

        // when & then
        assertThatThrownBy(() -> validator.checkCarNameInput(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CARNAME_LENGTH_EXCEPTION.getMessage() + "abcdef");
    }


    @Test
    @DisplayName("자동차의 이름이 공백인 경우 예외가 발생한다")
    void 자동차_이름_입력_테스트2() throws Exception {
        //given
        String carNames = ",abc,abcd,abcde";

        // when & then
        assertThatThrownBy(() -> validator.checkCarNameInput(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CARNAME_BLANK_EXCEPTION.getMessage());
    }

    @Test
    @DisplayName("중복된 자동차 이름이 주어진 경우 예외가 발생한다")
    void 자동차_이름_입력_테스트3() throws Exception {
        //given
        String carNames = "abc,abc,abcd,abcde";

        // when & then
        assertThatThrownBy(() -> validator.checkCarNameInput(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_CARNAME_EXCEPTION.getMessage() + "abc");
    }

    @Test
    @DisplayName("시도할 횟수 입력이 양의 정수가 아닌 경우에 예외가 발생한다")
    void 시도횟수_입력_테스트() throws Exception{
        //given
        String attempts = "-10";

        // when & then
        assertThatThrownBy(() -> validator.checkAttemptInput(attempts))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ATTEMPTS_FORMAT_EXCEPTION.getMessage() + attempts);
    }
}
