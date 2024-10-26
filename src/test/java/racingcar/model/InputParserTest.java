package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputParserTest {

    @Test
    @DisplayName("쉼표를 통한 자동차 이름 파싱")
    void parseCarNames_withValidInput() {
        String carNames = "car1,car2,car3";
        InputParser inputParser = new InputParser(carNames);

        assertThat(inputParser.getCarNameList())
            .containsExactly("car1", "car2", "car3");
    }

    @Test
    @DisplayName("자동차 이름 5자 초과 시 예외 발생")
    void validateLength_withExceededLength() {
        String carNames = "car12345,car2";

        assertThatThrownBy(() -> new InputParser(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름의 길이가 5를 초과하였습니다.");
    }

    @Test
    @DisplayName("자동차 이름 빈 문자열 입력 시 예외 발생")
    void throwExceptionWhenCarNamesIsEmpty() {
        String carNames = "";

        assertThatThrownBy(() -> new InputParser(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름이 아무것도 들어오지 않았습니다.");
    }
}
