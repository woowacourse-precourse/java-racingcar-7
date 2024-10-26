package racingcar.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {

    @Test
    @DisplayName("자동차의 이름이 6자 이상인 경우 예외가 발생한다")
    void 자동차_이름_입력_테스트1() throws Exception {
        //given
        Validator validator = new Validator();

        // when
        String carNames = "abc,abcd,abcde,abcdef";

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            validator.checkCarNameInput(carNames);
        });
    }


    @Test
    @DisplayName("자동차의 이름이 공백인 경우 예외가 발생한다")
    void 자동차_이름_입력_테스트2() throws Exception {
        //given
        Validator validator = new Validator();

        // when
        String carNames = ",abc,abcd,abcde";

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            validator.checkCarNameInput(carNames);
        });
    }

    @Test
    @DisplayName("중복된 자동차 이름이 주어진 경우 예외가 발생한다")
    void 자동차_이름_입력_테스트3() throws Exception {
        //given
        Validator validator = new Validator();

        // when
        String carNames = "abc,abc,abcd,abcde";

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            validator.checkCarNameInput(carNames);
        });
    }
}
