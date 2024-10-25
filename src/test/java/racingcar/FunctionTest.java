package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FunctionTest {
    @Test
    void 중복_이름이면_예외() {
        String testName = "pobi,holy,pobi";

        Assertions.assertThatThrownBy(() -> Application.registerCars(testName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되지 않은 이름을 입력해주세요");
    }

    @Test
    void 이름이_1자리_미만_또는_5자리_초과면_예외() {
        String testNameUnderOne = ""; //" ", "holy," 등은 처리 x
        String testNameOverFive = "pobiholymoly";

        Assertions.assertThatThrownBy(() -> Application.registerCars(testNameUnderOne))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1자리 이상 5자리 이하로 입력해주세요.");
        Assertions.assertThatThrownBy(() -> Application.registerCars(testNameOverFive))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1자리 이상 5자리 이하로 입력해주세요.");
    }
}
