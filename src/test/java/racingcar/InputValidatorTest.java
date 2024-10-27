package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();
    @Test
    void 자동차_이름_검증_성공_테스트() {
        inputValidator.validateCarNames(List.of("pobi", "woni", "jun"));
    }

    @Test
    void 자동차_이름_길이_초과_예외_테스트() {
        assertThatThrownBy(() -> inputValidator.validateCarNames(List.of("pobi", "woni", "jun", "pobiwoni")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 자동차_이름_공백_예외_테스트() {
        assertThatThrownBy(() -> inputValidator.validateCarNames(List.of("pobi", " ", "jun")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백으로 구성될 수 없습니다.");
    }

    @Test
    void 자동차_이름_중복_예외_테스트() {
        assertThatThrownBy(() -> inputValidator.validateCarNames(List.of("pobi", "pobi", "jun")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }
}