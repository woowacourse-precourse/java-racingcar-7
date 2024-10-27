package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingOutputViewTest {
    private final RacingOutputView outputView = new RacingOutputView();
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

    @Test
    void printWinnersTest() {
        List<String> winners = List.of("test", "cars");

        outputView.printWinners(winners);

        assertThat(out()).isEqualTo("최종 우승자 : test, cars");
    }
}