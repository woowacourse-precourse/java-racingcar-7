package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputTest {
    private Input input;

    @BeforeEach
    void Input_생성() {
        input = new Input();
    }

    @Test
    void 자동차_이름_유효성_테스트() {
        ArrayList<String> cars = new ArrayList<>();
        cars.add("java");
        cars.add("pipi");
        cars.add("totoro");
        assertThatThrownBy(() -> input.validateCarName1(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }
}
