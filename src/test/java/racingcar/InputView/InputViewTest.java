package racingcar.InputView;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputViewTest {
    private InputView inputView;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
        Console.close();
    }

    @Test
    void Given_자동차_이름을_입력_When_호출시_Expect_자동차_이름_목록을_반환한다() {
        String input = "Red, Blue, Green\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<String> carNames = inputView.getInputCarNames();
        assertEquals(3, carNames.size());
        assertEquals("Red", carNames.get(0));
        assertEquals("Blue", carNames.get(1));
        assertEquals("Green", carNames.get(2));
    }

    @Test
    void Given_이동_횟수를_입력_When_호출시_Expect_이동_횟수를_반환한다() {
        String input = "5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int tryCount = inputView.getInputTryCount();
        assertEquals(5, tryCount);
    }
}