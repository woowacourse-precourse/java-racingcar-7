package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private final InputStream systemIn = System.in;

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @AfterEach
    void restoreSystemIn() {
        Console.close();
    }

    @Test
    void 자동차_이름_입력() {
        // given
        String input = "car1,car2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        String result = inputView.requestCarNamesInput();

        // then
        assertEquals(input, result);
    }

    @Test
    void 시도_횟수_입력() {
        // given
        String input = "4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        String result = inputView.requestRoundNumberInput();

        // then
        assertEquals(input, result);
    }
}