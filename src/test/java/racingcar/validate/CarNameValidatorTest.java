package racingcar.validate;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameValidatorTest {

    @Test
    @DisplayName("자동차 이름 유효성 검사 성공")
    void CarNamesValidatorSuccess() {
        // given
        String input = "pobi,woni,jun";

        // when
        CarNameValidator.validateCarNames(input);

        // then
        Assertions.assertDoesNotThrow(() -> CarNameValidator.validateCarNames(input));
    }

    @Test
    @DisplayName("자동차 이름 유효성 검사 성공")
    void CarNamesListValidatorSuccess() {
        // given
        List<String> names = List.of("pobi", "woni", "jun");

        // when
        CarNameValidator.validateCarNames(names);

        // then
        Assertions.assertDoesNotThrow(() -> CarNameValidator.validateCarNames(names));
    }

    @Test
    @DisplayName("콤마는 시작과 끝에 올 수 없다.")
    void shouldNoEdgeComma() {
        // given
        String input = ",pobi,woni,jun";

        // expected
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> CarNameValidator.validateCarNames(input));
    }

    @Test
    @DisplayName("입력은 NULL 이나 공백이 올 수 없다.")
    void shouldNotNullOrBlank() {
        // given
        String input = null;

        // expected
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> CarNameValidator.validateCarNames(input));
    }

    @Test
    @DisplayName("콤마를 포함한 문장이여야한다.")
    void shouldHasComma() {
        // given
        String input = "pobiwonijun";

        // expected
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> CarNameValidator.validateCarNames(input));
    }

    @Test
    @DisplayName("문장은 알파벳과 숫자만 허용한다.")
    void shouldOnlyAllowedCharacter() {
        // given
        String input = "pobi,woni,jun@";

        // expected
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> CarNameValidator.validateCarNames(input));
    }

    @Test
    @DisplayName("이름은 5글자가 넘어선 안 된다.")
    void shouldCarNamesLength() {
        // given
        List<String> names = List.of("pobiii", "woni", "jun");

        // expected
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> CarNameValidator.validateCarNames(names));
    }

    @Test
    @DisplayName("자동차는 2대 이상이여야 한다.")
    void shouldCarNamesCount() {
        // given
        List<String> names = List.of("jun");

        // expected
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> CarNameValidator.validateCarNames(names));
    }
}