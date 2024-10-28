package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputParserTest {

    @Test
    @DisplayName("자동차 이름 문자열을 파싱하여 이름 리스트로 변환한다.")
    void parseCarNameStringToList() {
        // given
        String carNames = "pobi,woni,jun";

        // when
        List<String> result = InputParser.parseCarNames(carNames);

        // then
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("자동차 이름이 2개 미만이면 예외가 발생한다.")
    void lessThanTwoNamesException() {
        // given
        String carNames = "pobi";

        // when & then
        assertThatThrownBy(() -> InputParser.parseCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 2대 이상이어야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름에 5자를 초과하는 이름이 있으면 예외가 발생한다.")
    void carNameLengthExceedException() {
        // given
        String carNames = "pobi,longname";

        // when & then
        assertThatThrownBy(() -> InputParser.parseCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열이면 예외가 발생한다.")
    void EmptyNameException() {
        // given
        String carNames = "pobi, ";

        // when & then
        assertThatThrownBy(() -> InputParser.parseCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름에 공백이 포함되어 있습니다.");
    }

    @Test
    @DisplayName("자동차 이름에 중복된 값이 있으면 예외가 발생한다.")
    void duplicatedCarNameException() {
        // given
        String carNames = "pobi,woni,pobi";

        // when & then
        assertThatThrownBy(() -> InputParser.parseCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 자동차 이름이 있습니다.");
    }

    @Test
    @DisplayName("자동차 이름에 공백이 포함되어 있으면 예외가 발생한다.")
    void carNameContainsWhitespaceException() {
        // given
        String carNames = "po bi,woni,jun";

        // when & then
        assertThatThrownBy(() -> InputParser.parseCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름에 공백이 포함되어 있습니다.");
    }

    @Test
    @DisplayName("유효한 시도 횟수를 정수로 변환하여 반환한다.")
    void parseStringToInteger() {
        // given
        String tryCount = "5";

        // when
        int result = InputParser.parseTryCount(tryCount);

        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("시도 횟수가 유효하지 않은 문자열이면 예외가 발생한다.")
    void notValidTryCountException() {
        // given
        String tryCount = "five";

        // when & then
        assertThatThrownBy(() -> InputParser.parseTryCount(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 시도 횟수를 입력해 주세요");
    }

    @Test
    @DisplayName("시도 횟수가 1 미만일 경우 예외가 발생한다.")
    void tryCountUnderOneException() {
        // given
        String tryCount = "0";

        // when & then
        assertThatThrownBy(() -> InputParser.parseTryCount(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }
}
