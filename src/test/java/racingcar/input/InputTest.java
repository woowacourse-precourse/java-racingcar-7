package racingcar.input;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputTest {

    @Test
    @DisplayName("사용자의 입력을 ,를 기준으로 List로 분리한다.")
    void splitCar() {
        // given
        String input = "pobi,woni,jun";

        // when
        List<String> cars = Input.splitCar(input);

        // then
        Assertions.assertThat(cars).isEqualTo(List.of("pobi", "woni", "jun"));
    }
}