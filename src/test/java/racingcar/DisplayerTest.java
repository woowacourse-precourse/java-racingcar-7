package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DisplayerTest {

    private PrintStream standardOut;
    private OutputStream captor;

    private final DisplayerInterface displayer = new Displayer();

    protected final String output() {
        return captor.toString().trim();
    }

    @BeforeEach
    void setUp() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void showLog() {
        List<List<String>> log = List.of(
                List.of("car1 : -", "car2 : -", "car3 : -"),
                List.of("car1 : --", "car2 : --", "car3 : -"),
                List.of("car1 : ---", "car2 : --", "car3 : -")
        );

        displayer.showLog(log);

        String expectedOutput = String.join("\n\n",
                String.join("\n", "car1 : -", "car2 : -", "car3 : -"),
                String.join("\n", "car1 : --", "car2 : --", "car3 : -"),
                String.join("\n", "car1 : ---", "car2 : --", "car3 : -")
        );

        assertThat(output()).isEqualTo(expectedOutput);
    }

    @Test
    void showWinner() {
        List<String> winners = List.of("car1", "car2");

        displayer.showWinner(winners);

        String expectedOutput = "최종 우승자 : car1,car2";

        assertThat(output()).isEqualTo(expectedOutput);
    }
}
