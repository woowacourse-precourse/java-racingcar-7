package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    private Validator validator;

    @BeforeEach
    void beforeEach() {
        validator = new Validator();
    }

    @Test
    @DisplayName("자동차 이름 유효성 검사: 빈 문자열 이름 - 예외 테스트")
    void validateCarNames_emptyName() {
        // given
        List<String> carNames = Arrays.asList("pobi", "", "jun");

        // when & then
        assertThatThrownBy(() -> validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("자동차 이름 유효성 검사: 공백 포함 - 예외 테스트")
    void validateCarNames_nameWithSpaces() {
        // given
        List<String> carNames = Arrays.asList("pobi", "wo ni", "jun");

        // when & then
        assertThatThrownBy(() -> validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("자동차 이름 유효성 검사: 5글자 초과 - 예외 테스트")
    void validateCarNames_nameExceedMaxLength() {
        // given
        List<String> carNames = Arrays.asList("pobi", "woni", "leesoeun");

        // when & then
        assertThatThrownBy(() -> validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("자동차 이름 유효성 검사: 중복된 이름 - 예외 테스트")
    void validateCarNames_duplicateName() {
        // given
        List<String> carNames = Arrays.asList("pobi", "pobi", "jun");

        // when & then
        assertThatThrownBy(() -> validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);

    }
}