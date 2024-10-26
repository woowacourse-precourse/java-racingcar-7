package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarNames;

class InputValidatorTest {

    @Test
    @DisplayName("경주할 자동차 이름 - 정상 입력")
    void validCarName() {
        //given
        final String input = "pobi,woni, jun";

        //when
        final CarNames carNames = InputValidator.validateCarNameInput(input);

        //then
        assertThat(carNames.getCarNames()).contains("pobi").contains("woni").contains("jun");
    }

    @Test
    @DisplayName("경주할 자동차 이름 - 빈 문자열 입력")
    void blankCarNameInput() {
        //given
        final String input = "";

        //when
        final IllegalArgumentException exception = org.junit.jupiter.api.Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> InputValidator.validateCarNameInput(input));

        //then
        assertThat(exception.getMessage()).isEqualTo("경주할 자동차의 이름을 입력해 주세요.");
    }

    @Test
    @DisplayName("시도할 횟수 - 정상 입력")
    void validRoundCount() {
        //given
        final String input = "5";

        //when
        final int roundCount = InputValidator.validateRoundCountInput(input);

        //then
        assertThat(roundCount).isEqualTo(5);
    }

    @Test
    @DisplayName("시도할 횟수 - 빈 문자열 입력")
    void blackRoundCountInput() {
        //given
        final String input = "";

        //when & then
        assertThatThrownBy(() -> InputValidator.validateRoundCountInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수를 입력해 주세요.");
    }

    @Test
    @DisplayName("시도할 횟수 - 양의 정수가 아닌 문자 입력")
    void invalidRoundCount() {
        //given
        final String input = "a";

        //when & then
        assertThatThrownBy(() -> InputValidator.validateRoundCountInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양의 정수를 입력해 주세요.");
    }

    @Test
    @DisplayName("시도할 횟수 - 음수")
    void NegativeRoundCount() {
        //given
        final String input = "-5";

        //when & then
        assertThatThrownBy(() -> InputValidator.validateRoundCountInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양의 정수를 입력해 주세요.");
    }
}