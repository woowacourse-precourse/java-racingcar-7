package racingcar;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputHandlerTest {
    private final PrintStream originalOut = System.out; // 기존 System.out 저장
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private OutputHandler outputHandler = new OutputHandler();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void revert() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("경주 중간 상황 출력 테스트 : 정상 출력")
    void Should_Pass_When_RaceOnGoingWithNormal() {
        Map<String, Integer> input = new HashMap<>();
        input.put("pobi", 3);
        input.put("woni", 4);
        input.put("jun", 0);
        input.put("S", 1);
        input.put("b_man", 2);

        List<String> expectedResult = Arrays.asList("pobi : ---",
                "jun : ",
                "S : -",
                "woni : ----",
                "b_man : --");

        outputHandler.printRaceState(input);

        List<String> actualResults = Arrays.asList(outputStreamCaptor.toString().split(System.lineSeparator()));
        assertThat(actualResults).containsExactlyElementsOf(expectedResult);
    }

    @Test
    @DisplayName("경주 우승자 출력 테스트 : 정상 출력")
    void Should_Pass_When_RaceWinnersWithNormal() {
        List<String> input = new ArrayList<>();
        input.add("woni");
        input.add("b_man");

        String expectedResult = "woni, b_man";

        outputHandler.printRaceWinner(input);

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectedResult);
    }
}
