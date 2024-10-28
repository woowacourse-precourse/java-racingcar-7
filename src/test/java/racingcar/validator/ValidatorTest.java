package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static org.assertj.core.api.Assertions.*;
import java.util.HashMap;

class ValidatorTest {

    @Test
    @DisplayName("자동차 이름이 5자 초과인 경우 예외 발생")
    void shouldThrowExceptionForCarNameExceedingLength() {
        String[] carNames = {"pobi", "ericccc"};
        assertThatThrownBy(() -> Application.isValidCars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 숫자인 경우 예외 발생")
    void shouldThrowExceptionForNumericCarName() {
        String[] carNames = {"pobi", "12345"};
        assertThatThrownBy(() -> Application.isValidCars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 숫자일 수 없습니다.");
    }

    @Test
    @DisplayName("시도 횟수가 비어있을 때 예외 발생")
    void shouldThrowExceptionForEmptyAttemptCount() {
        assertThatThrownBy(() -> Application.checkIfNumeric(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 비어 있을 수 없습니다.");
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아닐 때 예외 발생")
    void shouldThrowExceptionForNonNumericAttemptCount() {
        assertThatThrownBy(() -> Application.checkIfNumeric("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("자동차 이름 초기화가 정상적으로 이루어지는지 확인")
    void shouldInitializeCarMapCorrectly() {
        String[] carNames = {"pobi", "woni"};
        HashMap<String, String> map = Application.initializeMap(carNames);
        assertThat(map).containsKeys("pobi", "woni");
        assertThat(map.get("pobi")).isEqualTo("");
        assertThat(map.get("woni")).isEqualTo("");
    }

    @Test
    @DisplayName("최대 전진 거리를 계산하여 우승자를 결정하는지 확인")
    void shouldFindCorrectWinner() {
        String[] carNames = {"pobi", "eddy"};
        HashMap<String, String> map = new HashMap<>();
        map.put("pobi", "---");
        map.put("eddy", "--");
        int totalLength = 0;

        for (String car : carNames) {
            totalLength = Application.setTotalLength(totalLength, map.get(car).length());
        }

        String winner = null;
        for (String car : carNames) {
            winner = Application.findWinner(totalLength, map.get(car).length(), car, winner);
        }

        assertThat(winner).isEqualTo("pobi");
    }
}
