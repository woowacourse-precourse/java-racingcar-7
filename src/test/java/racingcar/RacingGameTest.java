package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private OutputStream output;

    @BeforeEach
    public void init() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void finish() {
        System.setOut(System.out);
    }

    private String out() {
        return output.toString().trim();
    }

    private void setInput(String string) {
        InputStream input = new ByteArrayInputStream(string.getBytes());
        System.setIn(input);
        Console.close();
    }

    @Test
    void playTest() {
        setInput("test,cars\n1");
        RacingGame game = new RacingGame(new RacingInputView(), new RacingOutputView());

        assertRandomNumberInRangeTest(() -> {
            game.play();
            assertThat(out()).contains("실행 결과", "test : -", "cars : ", "최종 우승자 : test");
        }, MOVING_FORWARD, STOP);
    }
}