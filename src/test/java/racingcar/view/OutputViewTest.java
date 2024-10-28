package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputViewTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final OutputView outputView = new OutputView();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("게임 회차마다 진행상황 출력 테스트")
    public void printRecordTest() {
        List<Map<String, Integer>> record = Arrays.asList(
                new LinkedHashMap<>() {{
                    put("pobi", 1);
                    put("woni", 0);
                    put("jun", 1);
                }},
                new LinkedHashMap<>() {{
                    put("pobi", 2);
                    put("woni", 1);
                    put("jun", 2);
                }},
                new LinkedHashMap<>() {{
                    put("pobi", 3);
                    put("woni", 2);
                    put("jun", 3);
                }}
        );
        String expected = """
                실행 결과
                pobi : -
                woni :\s
                jun : -
                
                pobi : --
                woni : -
                jun : --
                
                pobi : ---
                woni : --
                jun : ---
                
                """;

        outputView.printRecord(record);
        String result = outputStreamCaptor.toString().replaceAll("\\r\\n", "\n").replaceAll("\\r", "\n");

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("최종 우승자 출력 테스트")
    public void printWinnersTest() {
        List<String> winners = Arrays.asList("pobi", "jun");
        String expected = "최종 우승자 : pobi, jun\n";

        outputView.printWinners(winners);
        String result = outputStreamCaptor.toString().replaceAll("\\r\\n", "\n").replaceAll("\\r", "\n");

        assertEquals(expected, result);
    }
}
