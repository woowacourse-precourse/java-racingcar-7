package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarInputHandlerTest {
    private CarInputHandler carInputHandler = new CarInputHandler();
    @BeforeEach
    void setUp() {
        carInputHandler = new CarInputHandler();
    }

    @Test
    void userInputCarNames_유효한_입력() {
        System.setIn(new ByteArrayInputStream("자동차1, 자동차2".getBytes()));

        String result = carInputHandler.userInputCarNames();

        assertThat(result).isEqualTo("자동차1, 자동차2");
    }

    @Test
    void splitCarNames_유효한_입력() {
        String[] result = carInputHandler.splitCarNames("자동차1, 자동차2, 자동차3");

        assertThat(result).containsExactly("자동차1", "자동차2", "자동차3");
    }

    @Test
    void splitCarNames_자동차이름_중복_예외발생() {
        assertThatThrownBy(() -> carInputHandler.splitCarNames("자동차1, 자동차2, 자동차1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력하신 자동차 이름중에 중복이 있습니다.");
    }

    @Test
    void splitCarNames_이름_길이_초과_예외발생() {
        assertThatThrownBy(() -> carInputHandler.splitCarNames("자동차1, 자동차이름길게"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하로 입력해야 합니다.");
    }
}
