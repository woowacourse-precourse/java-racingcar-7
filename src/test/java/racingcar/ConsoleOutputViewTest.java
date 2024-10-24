package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.output.ConsoleOutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ConsoleOutputViewTest {

    private ConsoleOutputView outputView;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        outputView = new ConsoleOutputView();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    @DisplayName("라운드 결과를 출력한다")
    void printRoundResult() {
        // given
        List<String> results = Arrays.asList(
                "pobi : --",
                "woni : -"
        );

        // when
        outputView.printRoundResult(results);

        // then
        String output = outContent.toString();
        assertTrue(output.contains("pobi : --"));
        assertTrue(output.contains("woni : -"));
    }

    @Test
    @DisplayName("우승자를 출력한다")
    void printWinners() {
        // given
        List<String> winners = Arrays.asList("pobi", "jun");

        // when
        outputView.printWinners(winners);

        // then
        assertTrue(outContent.toString().contains("최종 우승자 : pobi, jun"));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
    }
}
