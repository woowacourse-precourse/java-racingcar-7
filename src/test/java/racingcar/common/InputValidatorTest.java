package racingcar.common;

import org.junit.jupiter.api.Test;
import racingcar.model.InputValidator;

import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();

    @Test
    void 자동차이름_정상_하나의_자동차() {
        //given
        String carNames = "woody";

        //when

        //then
        assertThatCode(() -> inputValidator.validateCarNames(carNames))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차이름_정상_다수의_자동차() {
        //given
        String carNames = "woody,fobi";

        //when

        //then
        assertThatCode(() -> inputValidator.validateCarNames(carNames))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차이름_빈문자열_X() {
        //given
        String carNames = "";

        //when

        //then
        assertThatThrownBy(() -> inputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_공백_X() {
        //given
        String carNames = " ";

        //when

        //then
        assertThatThrownBy(() -> inputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_쉼표를_제외한_특수문자_X() {
        //given
        String carNames = "woody.fobi";

        //when

        //then
        assertThatThrownBy(() -> inputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_6자이상_X() {
        //given
        String carNames = "woody,fobi,abcdef";

        //when

        //then
        assertThatThrownBy(() -> inputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_정상() {
        //given
        String carNames = "4";

        //when

        //then
        assertThatCode(() -> inputValidator.validateTryCounts(carNames))
                .doesNotThrowAnyException();
    }

    @Test
    void 시도횟수_숫자만_허용_문자열_X() {
        //given
        String carNames = "woody";

        //when

        //then
        assertThatThrownBy(() -> inputValidator.validateTryCounts(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_숫자만_허용_공백_X() {
        //given
        String carNames = "";

        //when

        //then
        assertThatThrownBy(() -> inputValidator.validateTryCounts(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}