package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    @Test
    void shouldPrintWhenPlayOneRound() {
        Input input = new Input("alpha,beta", "1");
        Racing racing = new Racing(input.splitCarNameInput());

        PrintStream originalOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        assertRandomNumberInRangeTest(racing::runRound, 4, 3);

        String output = outputStream.toString();

        assertThat(output).contains("alpha : -", "beta : ", "");

        System.setOut(originalOut);
    }

    @Test
    void shouldPrintLongestDistCarNameWhenPlayAllRound() {
        Input input = new Input("alpha,beta,delta", "1");
        Racing racing = new Racing(input.splitCarNameInput());

        PrintStream originalOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        assertRandomNumberInRangeTest(() -> {
            racing.runAllRound(Integer.parseInt(input.getRounds()));
            racing.getWinner();
        }, 4, 3, 3);

        String output = outputStream.toString();

        assertThat(output).contains("최종 우승자 : alpha");

        System.setOut(originalOut);
    }

    @Test
    void shouldPrintLongestDistCarNamesWhenPlayAllRound() {
        Input input = new Input("alpha,beta,delta", "1");
        Racing racing = new Racing(input.splitCarNameInput());

        PrintStream originalOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        assertRandomNumberInRangeTest(() -> {
            racing.runAllRound(Integer.parseInt(input.getRounds()));
            racing.getWinner();
        }, 4, 4, 3);

        String output = outputStream.toString();

        assertThat(output).contains("최종 우승자 : alpha, beta");

        System.setOut(originalOut);
    }
}

