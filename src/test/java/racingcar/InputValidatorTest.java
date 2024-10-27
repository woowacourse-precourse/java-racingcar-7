package racingcar;


import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.utils.Constant;
import racingcar.utils.InputValidator;

public class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();

    @Test
    void 자동차_이름은_쉼표로_파싱이_가능해야한다() {
        List<String> carNames = inputValidator.validateCarNames("aaa,bbb,ccc");

        assertThat(carNames).containsExactly("aaa", "bbb", "ccc");
        assertThat(carNames.size()).isEqualTo(3);
    }

    @Test
    void 자동차_이름에_빈문자열이_포함되면_에러가_발생해야한다() {
        assertThatThrownBy(() -> inputValidator.validateCarNames(",bb,ccc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.CAR_NAME_EMPTY_ERROR_MESSAGE);
    }

    @Test
    void 자동차_이름은_5자_이하만_가능하다() {
        assertThatThrownBy(() -> inputValidator.validateCarNames("aa,bb,ccc,dddddddd"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.CAR_NAME_LENGTH_ERROR_MESSAGE);
    }

    @Test
    void 자동차_이름에_공백만_있다면_에러가_발생한다() {
        assertThatThrownBy(() -> inputValidator.validateCarNames("aa,bb,ccc, "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.CAR_NAME_EMPTY_ERROR_MESSAGE);
    }

    @Test
    void 중복된_자동차_이름이_있다면_에러가_발생한다() {
        assertThatThrownBy(() -> inputValidator.validateCarNames("aa,aa,bbb"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.CAR_NAME_DUPLICATE_ERROR_MESSAGE);
    }

    @Test
    void 시도_횟수는_정수로_파싱되어야한다() {
        int attemptCount = inputValidator.validateAttemptCount("10");

        assertThat(attemptCount).isEqualTo(10);
    }

    @Test
    void 시도_횟수에_음수를_입력하면_에러가_발생한다() {
        assertThatThrownBy(() -> inputValidator.validateAttemptCount("-6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.ATTEMPT_COUNT_NUMBER_ERROR_MESSAGE);
    }

    @Test
    void 시도_횟수에_0을_입력하면_에러가_발생한다() {
        assertThatThrownBy(() -> inputValidator.validateAttemptCount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.ATTEMPT_COUNT_NUMBER_ERROR_MESSAGE);
    }

    @Test
    void 시도_횟수에_정수가_아닌_값을_입력하면_에러가_발생한다() {
        assertThatThrownBy(() -> inputValidator.validateAttemptCount("20.21"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.ATTEMPT_COUNT_NUMBER_ERROR_MESSAGE);
    }
}
