package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void 이름길이_초과_입력_테스트() {
        List<String> input = List.of("abcdef", "123456");
        assertThatThrownBy(() -> Validator.validateName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_입력_테스트() {
        List<String> input = List.of("", " ");
        assertThatThrownBy(() -> Validator.validateName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정수_검증_테스트() {
        int result = Validator.validateCycle("4");
        assertEquals(4, result);
    }

    @Test
    void 정수가_아닐때_예외_테스트() {
        List<String> invalidInputs = List.of("A", "*", "0.1");

        for (String input : invalidInputs) {
            assertThatThrownBy(() -> Validator.validateCycle(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 음수값_예외_테스트() {
        assertThatThrownBy(() -> Validator.validateCycle("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_제로입력_예외_테스트() {
        String input1 = " ";
        String input2 = "";

        assertThatThrownBy(() -> Validator.validateCycle(input1))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Validator.validateCycle(input2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}