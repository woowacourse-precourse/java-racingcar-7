package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    public void 입력이_없는_경우() {
        InputValidator inputValidator = new InputValidator();

        boolean hasNoInput = inputValidator.hasNoInput("");

        Assertions.assertThat(hasNoInput).isTrue();
    }

    @Test
    public void 이름이_6자_이상인_경우() {
        InputValidator inputValidator = new InputValidator();

        boolean length4 = inputValidator.checkInputLength("pobi,woni,jun"); //4자인 경우
        boolean length5 = inputValidator.checkInputLength("pobii,woni,jun");//5자인 경우
        boolean length6 = inputValidator.checkInputLength("pobiii,woni,jun");//6자인 경우

        Assertions.assertThat(length4).isTrue();
        Assertions.assertThat(length5).isTrue();
        Assertions.assertThat(length6).isFalse();
    }

}