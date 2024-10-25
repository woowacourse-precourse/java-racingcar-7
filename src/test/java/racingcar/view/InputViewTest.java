package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

class InputViewTest {

/*    @Test
    void 자동차_이름_입력_테스트() {
        // given
        String input = "pobi,woni,jun\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        List<String> carNames = InputView.getCarNames();

        // then
        assertEquals(List.of("pobi", "woni", "jun"), carNames);
    }*/

    @Test
    void 라운드_입력_테스트() {
        // given
        String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        String rounds = InputView.getRounds();

        // then
        assertEquals("5", rounds);
    }
}