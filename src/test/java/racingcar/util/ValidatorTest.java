package racingcar.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
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

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.checkCarNameInput(carNames));

        // then
        assertEquals(CARNAME_LENGTH_EXCEPTION.getMessage() + "abcdef", exception.getMessage());
    }


    @Test
    @DisplayName("자동차의 이름이 공백인 경우 예외가 발생한다")
    void 자동차_이름_입력_테스트2() throws Exception {
        //given
        String carNames = ",abc,abcd,abcde";

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.checkCarNameInput(carNames));

        // then
        assertEquals(CARNAME_BLANK_EXCEPTION.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("중복된 자동차 이름이 주어진 경우 예외가 발생한다")
    void 자동차_이름_입력_테스트3() throws Exception {
        //given
        String carNames = "abc,abc,abcd,abcde";

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.checkCarNameInput(carNames));

        // then
        assertEquals(DUPLICATE_CARNAME_EXCEPTION.getMessage() + "abc", exception.getMessage());
    }
}
