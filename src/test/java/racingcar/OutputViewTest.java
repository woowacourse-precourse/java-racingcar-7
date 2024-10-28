package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    @DisplayName("우승자 출력 테스트")
    void testDisplayWinners() {
        List<String> winners = List.of("Alpha", "Bravo");

        OutputView.displayWinners(winners);

        String output = outContent.toString();
        assertThat(output).isEqualToNormalizingNewlines("최종 우승자 : Alpha, Bravo\n");
    }

    @Test
    @DisplayName("라운드별 결과를 올바르게 출력하는지 테스트")
    void testDisplayResults() {
        List<String> carNames = Arrays.asList("Alpha", "Bravo", "Choco");
        RacingGame racingGame = new RacingGame(carNames);

        assertRandomNumberInRangeTest(() -> racingGame.play(1),
                MOVING_FORWARD, STOP, MOVING_FORWARD);

        List<RoundResult> roundResults = racingGame.getRoundResults();

        OutputView.displayResults(roundResults);

        String actualOutput = outContent.toString();
        // 경고 메시지 부분을 필터링하여 제거
        String filteredOutput = actualOutput.replaceAll(
                "(?m)^Mockito is currently self-attaching to enable the inline-mock-maker.*\\R?", "");

        // 기대 출력에 공백과 줄바꿈 포함
        String expectedOutput = "\n실행 결과\n" +
                "Alpha : -\n" +
                "Bravo : \n" +
                "Choco : -\n" +
                "\n";

        assertThat(filteredOutput).isEqualToNormalizingNewlines(expectedOutput);
    }
}