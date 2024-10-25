package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FunctionTest {
    @Test
    void 중복_이름이면_예외() {
        String testName = "pobi,holy,pobi";

        Assertions.assertThatThrownBy(() -> Application.registerCars(testName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되지 않은 이름을 입력해주세요");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "pobiholymoly"})
    void 이름이_1자리_미만_또는_5자리_초과면_예외(String testName) {
        //" ", "holy," 등은 처리 x
        Assertions.assertThatThrownBy(() -> Application.registerCars(testName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1자리 이상 5자리 이하로 입력해주세요.");
    }

    @Test
    void 차_개수가_1개_이하면_예외() {
        String testName = "pobi";

        Assertions.assertThatThrownBy(() -> Application.registerCars(testName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("2개 이상의 차 이름을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    void 이동_횟수가_1이하면_예외(String testNumber) {
        Assertions.assertThatThrownBy(() -> Application.validateMoveNumber(testNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1회 이상의 이동 횟수를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a1", "8.8", "1.0"})
    void 이동_횟수가_정수가_아니면_예외(String testNumber) {
        Assertions.assertThatThrownBy(() -> Application.validateMoveNumber(testNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("정수로 된 이동 횟수를 입력해주세요.");
    }
}
