package racingcar.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    @Test
    void 자동차_이름_입력_테스트() {
        // given
        String input = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        List<String> carNames = InputView.getCarNames();

        // then
        assertEquals(List.of("pobi", "woni", "jun"), carNames);
    }
}