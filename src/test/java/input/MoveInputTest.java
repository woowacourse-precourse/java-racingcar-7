package input;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;


@DisplayName("시도 횟수 입력값 관련 테스트")
public class MoveInputTest extends NsTest {
    @DisplayName("입력된 시도 횟수 문자열이 숫자가 아닌 다른 형식의 문자열이 입력됐을 경우 예외 발생")
    @Test
    void 실패_시도횟수문자열_숫자형식X() {
        // Given
        String correctCarName = "honi,juni";
        String numberOfMoveCannotParseInteger = "six";

        // When&Then
        assertThatThrownBy(() -> runException(correctCarName, numberOfMoveCannotParseInteger))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력하신 문자열은 시도 횟수 형식이 아닙니다. 1000이하의 숫자를 입력해주세요.");
    }

    @DisplayName("입력된 시도 횟수 문자열이 0이하의 숫자일 경우 예외 발생")
    @Test
    void 실패_시도횟수문자열_0이하숫자() {
        // Given
        String correctCarName = "honi,juni";
        String numberOfMoveLessThanZero = "-1";

        // When&Then
        assertThatThrownBy(() -> runException(correctCarName, numberOfMoveLessThanZero))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력하신 숫자로는 자동차를 움직일 수 없습니다. 1 이상의 숫자를 입력해주세요.");
    }

    @DisplayName("입력된 시도 횟수 문자열이 1001 이상의 숫자일 경우 예외 발생 ")
    @Test
    void 실패_시도횟수문자열_1001이상숫자() {
        // Given
        String correctCarName = "honi,juni";
        String numberOfMoveMoreThan1000 = "9999";

        // When&Then
        assertThatThrownBy(() -> runException(correctCarName, numberOfMoveMoreThan1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력하신 숫자는 레이싱 시도횟수에 적합하지 않습니다. 1000이하의 숫자를 입력해주세요.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
