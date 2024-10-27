package racingcar;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CarInputTest {
    @Test
    void 자동차_이름_유효성_검증_테스트() {
        // 정상적인 이름 입력 (5자 이하)
        String[] validNames = {"pobi", "woni"};
        assertThatCode(() -> CarInput.validateCarNames(validNames))
                .doesNotThrowAnyException();

        // 잘못된 이름 입력 (5자 초과)
        String[] invalidNames = {"pobi", "woniwoni"};
        assertThatThrownBy(() -> CarInput.validateCarNames(invalidNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상 5자 이하여야 합니다");
    }
}
