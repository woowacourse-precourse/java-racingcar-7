package racingcar.validate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import racingcar.exception.ErrorMessage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @Test
    @DisplayName("이름 - 성공적인 경우")
    void nameSuccessTest() {
        // given
        Validator validator = new Validator();
        List<String> names = List.of("pla", "Yer");

                assertDoesNotThrow(() -> {
            for (String name: names) {
                validator.validateName(name);
            }
        });
    }

    @Test
    @DisplayName("이름 - 공백인 경우")
    void blankTest() {
        // given
        Validator validator = new Validator();
        List<String> names = List.of("pla", "");

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            for (String name : names) {
                validator.validateName(name);
            }
        });

        // then
        assertEquals(ErrorMessage.INPUT_NOT_BLANK.getMessage(),
                exception.getMessage());
    }

    @Test
    @DisplayName("이름 - 5자 초과한 경우")
    void longNameTest() {
        // given
        Validator validator = new Validator();
        List<String> names = List.of("player", "rose");

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            for (String name : names) {
                validator.validateName(name);
            }
        });

        // then
        assertEquals(ErrorMessage.LONG_NAME.getMessage(),
                exception.getMessage());
    }

    @Test
    @DisplayName("이름 - 중복이 존재하는 경우")
    void existNameTest() {
        // given
        Validator validator = new Validator();
        List<String> names = List.of("rose", "rose");

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            for (String name : names) {
                validator.validateName(name);
            }
        });

        // then
        assertEquals(ErrorMessage.EXIST_NAME.getMessage(),
                exception.getMessage());
    }

    @Test
    @DisplayName("이름 - 영어가 아닌 경우")
    void notOnlyEnglishTest() {
        // given
        Validator validator = new Validator();
        List<String> names = List.of("r0se", "rose");

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            for (String name : names) {
                validator.validateName(name);
            }
        });

        // then
        assertEquals(ErrorMessage.NOT_ENGLISH.getMessage(),
                exception.getMessage());
    }

    @Test
    @DisplayName("숫자 - 성공적인 경우")
    void numSuccessTest() {
        // given
        Validator validator = new Validator();
        String num = "35";

        assertDoesNotThrow(() -> {
            validator.validateNum(num);
        });
    }

    @Test
    @DisplayName("숫자 - 공백인 경우")
    void numBlankTest() {
        // given
        Validator validator = new Validator();
        String num = "";

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateNum(num);
        });

        // then
        assertEquals(ErrorMessage.INPUT_NOT_BLANK.getMessage(),
                exception.getMessage());
    }

    @Test
    @DisplayName("숫자 - 숫자가 아닌 경우")
    void notNumTest() {
        // given
        Validator validator = new Validator();
        String num = "rose";

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validateNum(num);
        });

        // then
        assertEquals(ErrorMessage.NOT_NUM.getMessage(),
                exception.getMessage());
    }
}