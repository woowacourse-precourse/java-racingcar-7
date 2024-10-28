package racingcar;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    RacingGame racingGame = new RacingGame();
    String testCarNames = "Foo,Bar, Lee\n";
    String testRounds = "5\n";

    @Test
    public void 정상_동작() {
        setSystemInput(testCarNames + testRounds);

        racingGame.receiveInput();
        racingGame.play();
    }

    private void setSystemInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
