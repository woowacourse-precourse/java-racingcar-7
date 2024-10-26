package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputParserTest {

    @Test
    @DisplayName("정상적인 자동차 이름, 시도 횟수 입력 테스트")
    void parseCarNamesAndTryCount_withValidInput() {
        String carNames = "car1,car2,car3";
        String tryCount = "5";
        InputParser inputParser = new InputParser(carNames, tryCount);

        assertThat(inputParser.getCarNameList())
            .containsExactly("car1", "car2", "car3");
        assertThat(inputParser.getTryCount())
            .isEqualTo(5);
    }

    @Test
    @DisplayName("자동차 이름 5자 초과 시 예외 발생")
    void validateLength_withExceededLength() {
        String carNames = "car12345,car2";
        String tryCount = "5";

        assertThatThrownBy(() -> new InputParser(carNames, tryCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름의 길이가 5를 초과하였습니다.");
    }

    @Test
    @DisplayName("자동차 이름 빈 문자열 입력 시 예외 발생")
    void throwException_whenCarNamesIsEmpty() {
        String carNames = "";
        String tryCount = "5";

        assertThatThrownBy(() -> new InputParser(carNames, tryCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름이 아무것도 들어오지 않았습니다.");
    }

    @Test
    @DisplayName("시도 횟수로 문자 입력 시 예외 발생")
    void throwException_whenTryCountIsNotANumber() {
        String carNames = "car1,car2,car3";
        String tryCount = "gafds";

        assertThatThrownBy(() -> new InputParser(carNames, tryCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("알맞지 않은 시도 횟수 값이 들어왔습니다.");
    }

    @Test
    @DisplayName("시도 횟수로 0 이하 값 입력 시 예외 발생")
    void throwException_whenTryCountIsZeroOrNegative() {
        String carNames = "car1,car2,car3";
        String tryCount = "-1";

        assertThatThrownBy(() -> new InputParser(carNames, tryCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("알맞지 않은 시도 횟수 값이 들어왔습니다.");
    }
}
