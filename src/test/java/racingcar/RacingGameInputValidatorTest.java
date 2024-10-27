package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameInputValidatorTest {

    @Test
    @DisplayName("쉼표로 구분된 이름들을 리스트로 분리")
    void parseValidCarNames() {
        String input = "pobi,woni,jun";
        List<String> names = RacingGameInputValidator.parseCarNames(input);

        assertThat(names).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("입력이 null이거나 빈 문자열인 경우 예외 발생")
    void validateEmptyInput() {
        assertThatThrownBy(() -> RacingGameInputValidator.parseCarNames(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 입력해주세요.");
    }

    @Test
    @DisplayName("쉼표 사이에 빈 이름이 있는 경우 예외 발생")
    void validateEmptyName() {
        assertThatThrownBy(() -> RacingGameInputValidator.parseCarNames("pobi,,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 이름이 포함되어 있습니다.");
    }

    @Test
    @DisplayName("공백만 있는 이름이 포함된 경우 예외 발생")
    void validateBlankName() {
        assertThatThrownBy(() -> RacingGameInputValidator.parseCarNames("pobi, ,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 이름이 포함되어 있습니다.");
    }
}