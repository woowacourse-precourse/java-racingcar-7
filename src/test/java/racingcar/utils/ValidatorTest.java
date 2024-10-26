package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    void 자동차_이름_입력_검증_테스트() {
        String validInput = "povi,hhj,java";
        String invalidInput = "povi,hhj.java";

        // 유효한 입력에 대해 예외가 발생하지 않는지 확인
        Assertions.assertThatCode(() -> InputValidator.nameValidator(validInput))
                .doesNotThrowAnyException();

        // 유효하지 않은 입력에 대해 IllegalArgumentException 이 발생하는지 확인
        Assertions.assertThatThrownBy(() -> InputValidator.nameValidator(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름 입력이 잘못되었습니다.");    }
}
