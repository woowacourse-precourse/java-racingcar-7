package racingcar.io.input;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputTest {

    @Test
    @DisplayName("사용자의 입력을 ,를 기준으로 List로 분리한다.")
    void splitCarNames() {
        // given
        ByteArrayInputStream in = new ByteArrayInputStream("pobi,woni,jun".getBytes());
        System.setIn(in);

        // when
        List<String> carNames = Input.inputCarNames();

        // then
        Assertions.assertEquals(carNames, List.of("pobi", "woni", "jun"));
    }
}