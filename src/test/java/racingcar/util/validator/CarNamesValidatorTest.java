package racingcar.util.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNamesValidatorTest {
    private static final String INVALID_SEPARATOR_POSITION_MESSAGE = "구분자는 입력의 첫번째 또는 마지막에 올 수 없습니다";
    private static final String INVALID_CONSECUTIVE_SEPARATOR_MESSAGE = "연속된 구분자를 사용할 수 없습니다.";
    private static final String INVALID_CAR_COUNT_MESSAGE = "자동차는 최소 1대 이상 100대 이하로만 가능합니다.";
    private static final String INVALID_CAR_NAME_MESSAGE = "자동차 이름은 최소 1자 이상 5자 이하만 가능합니다.";

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun", "pobi", "pobi,woni"})
    @DisplayName("자동차이름 입력이 정상적일 때 예외가 발생하지 않는다")
    public void validaInputTest(String input) {
        assertDoesNotThrow(() -> CarNamesValidator.validate(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {",pobi,woni,jun", "pobi,", "pobi,woni,"})
    @DisplayName("입력의 첫번째 혹은 마지막에 구분자가 있는 경우 예외가 발생한다")
    public void separatorPositionErrorTest(String input) {
        assertThatThrownBy(() -> CarNamesValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_SEPARATOR_POSITION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"p,,obi,woni,jun", "pob,,i"})
    @DisplayName("입력에 연속된 구분자가 있는 경우 예외가 발생한다")
    public void consecutiveSeparatorPositionErrorTest(String input) {
        assertThatThrownBy(() -> CarNamesValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_CONSECUTIVE_SEPARATOR_MESSAGE);
    }

    @Test
    @DisplayName("자동차 갯수가 100대가 넘을 경우 예외가 발생한다")
    public void outOfCarCountsErrorTest() {
        String carNames = IntStream.rangeClosed(0, 100)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
        assertThatThrownBy(() -> CarNamesValidator.validate(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_CAR_COUNT_MESSAGE);
    }

    @Test
    @DisplayName("입력이 빈 문자열일 경우 예외가 발생한다")
    public void emptyInputErrorTest() {
        String input = "";
        assertThatThrownBy(() -> CarNamesValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_CAR_NAME_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"p,obi123,jun", "pob,i12345"})
    @DisplayName("자동차 이름이 5자 넘어가는 이름이 있을 경우 예외가 발생한다")
    public void outOfLengthCarNameErrorTest(String input) {
        assertThatThrownBy(() -> CarNamesValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_CAR_NAME_MESSAGE);
    }
}
