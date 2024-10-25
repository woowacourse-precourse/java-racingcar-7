package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    @DisplayName("경주할 자동차 이름 - 정상 입력")
    void validCarName() {
        //given
        final String input = "pobi,woni, jun";

        //when
        final List<String> carNames = InputValidator.validateCarNameInput(input);

        //then
        assertThat(carNames).contains("pobi").contains("woni").contains("jun");
    }

    @Test
    @DisplayName("경주할 자동차 이름 - 빈 문자열 입력")
    void blankCarNameInput() {
        //given
        final String input = "";

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateCarNameInput(input));

        //then
        assertThat(exception.getMessage()).isEqualTo("경주할 자동차의 이름을 입력해 주세요.");
    }

    @Test
    @DisplayName("경주할 자동차 이름 - 이름을 공백으로 입력")
    void blackCarName() {
        //given
        final String input = "a, ,c";

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateCarNameInput(input));

        //then
        assertThat(exception.getMessage()).isEqualTo("이름을 지정하지 않은 자동차가 있습니다.");
    }

    @Test
    @DisplayName("경주할 자동차 이름 - 이름이 5자 이상")
    void tooLongCarName() {
        //given
        final String input = "abcdef, i, j";

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateCarNameInput(input));

        //then
        assertThat(exception.getMessage()).isEqualTo("자동차의 이름은 5자 이하로 설정해 주세요.");
    }

    @Test
    @DisplayName("경주할 자동차 이름 - 중복된 이름 입력")
    void duplicatedCarName() {
        //given
        final String input = "jo,jo,ha";

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateCarNameInput(input));

        //then
        assertThat(exception.getMessage()).isEqualTo("중복된 자동차 이름이 존재합니다.");
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

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateRoundCountInput(input));

        //then
        assertThat(exception.getMessage()).isEqualTo("시도할 횟수를 입력해 주세요.");
    }

    @Test
    @DisplayName("시도할 횟수 - 양의 정수가 아닌 문자 입력")
    void invalidRoundCount() {
        //given
        final String input = "a";

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateRoundCountInput(input));

        //then
        assertThat(exception.getMessage()).isEqualTo("양의 정수를 입력해 주세요.");
    }
}