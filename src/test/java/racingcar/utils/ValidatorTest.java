package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    void 자동차_이름_입력_검증_테스트() {
        String validInput = "povi,hhj,java";
        String invalidInput = "povi,hhj.java";
        String invalidInput2 = "hohoho,hhj,java";
        // hohoho -> 6 자 이름

        // 유효한 입력
        Assertions.assertThatCode(() -> InputValidator.nameValidator(validInput))
                .doesNotThrowAnyException();

        // 잘못된 구분자 사용
        Assertions.assertThatThrownBy(() -> InputValidator.nameValidator(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자를 확인해주세요.");

        // 5자 이상의 이름
        Assertions.assertThatThrownBy(() -> InputValidator.nameValidator(invalidInput2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 시도할_횟수_입력_검증_테스트() {
        String validInput = "12";
        String invalidInput = "12a";

        // 유효한 입력에 대해 예외가 발생하지 않는지 확인
        Assertions.assertThatCode(() -> InputValidator.numberValidator(validInput))
                .doesNotThrowAnyException();

        Assertions.assertThatThrownBy(() -> InputValidator.numberValidator(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("횟수 입력이 잘못되었습니다.");
    }
}
