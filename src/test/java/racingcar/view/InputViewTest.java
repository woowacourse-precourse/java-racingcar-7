package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputViewTest {
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @AfterEach
    void clear() {
        Console.close();
    }

    @Test
    void 올바른_레이싱카_이름을_받는다() {
        InputStream inputStream = new ByteArrayInputStream("1234,bn\n".getBytes());
        System.setIn(inputStream);

        assertEquals("1234,bn", inputView.getRacingCarNames());
    }

    @Test
    void 올바른_시도_횟수를_받는다() {
        InputStream inputStream = new ByteArrayInputStream("12\n".getBytes());
        System.setIn(inputStream);

        assertEquals("12", inputView.getTotalAttempts());
    }
}