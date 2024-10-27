package racingcar.custom_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.ExceptionClass;
import racingcar.view.InputView;

public class ExceptionTest {
    private InputView inputView;
    private ExceptionClass exception;
    @BeforeEach
    void setUp() {
        inputView = InputView.getInstance();
        exception = ExceptionClass.getInstance();
    }

    @Test
    @DisplayName("입력 문자열이 5자 초과")
    void tooLongStringTest(){
        String[] invalidInput = new String[]{"asdf", "asdfasdfsdaf"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {exception.validateString(invalidInput);});
    }

    @Test
    @DisplayName("입력 문자열이 공백과 ,만 존재하는 경우")
    void blankTest(){
        String[] invalidInput = new String[0];
        Assertions.assertThrows(IllegalArgumentException.class, () -> {exception.validateString(invalidInput);});
    }
}
