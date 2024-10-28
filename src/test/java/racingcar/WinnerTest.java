package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.ConsoleMessage.WINNER_INFORM_MESSAGE;

public class WinnerTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        // System.out을 가상 출력 스트림으로 변경
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        // 원래 System.out으로 복구
        System.setOut(originalOut);
    }

    @Test
    void 우승자의_이름_한명_응답_성공_테스트() {
        //given
        int maxPositioin = 5;
        Map<String, Integer> cars = Map.of("pobi", 5, "woni", 4, "jun", 2);
        List<String> winnerName = List.of("pobi");

        //then
        assertThat(Application.getWinnersName(cars, maxPositioin))
                .isEqualTo(winnerName);
    }

    @Test
    void 우승자의_이름_두명_응답_성공_테스트() {
        //given
        int maxPositioin = 6;
        Map<String, Integer> cars = Map.of("pobi", 6, "woni", 6, "jun", 2);
        List<String> winnerName = List.of("pobi", "woni");

        //then
        assertThat(Application.getWinnersName(cars, maxPositioin))
                .contains("pobi", "woni");

    }

    @Test
    void 우승자_한명_출력_테스트() {

        //given
        List<String> winnerName = List.of("pobi");
        String expectedOutput = WINNER_INFORM_MESSAGE + "pobi";

        //when
        Application.printWinner(winnerName);

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectedOutput);
    }

    @Test
    void 우승자_두명_출력_테스트() {

        //given
        List<String> winnerName = List.of("pobi", "woni");

        //when
        Application.printWinner(winnerName);

        assertThat(outputStreamCaptor.toString().trim()).contains("pobi", "woni");
    }
}
