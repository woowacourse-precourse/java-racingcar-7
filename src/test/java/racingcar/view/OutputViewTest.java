package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
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
        String expectedOutput = """
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
        String actualOutput = outputStreamCaptor.toString().replaceAll("\\r\\n", "\n").replaceAll("\\r", "\n");

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void printWinnersTest() {
        List<String> winners = Arrays.asList("pobi", "jun");
        String expectedOutput = "최종 우승자 : pobi, jun\n";

        outputView.printWinners(winners);
        String actualOutput = outputStreamCaptor.toString().replaceAll("\\r\\n", "\n").replaceAll("\\r", "\n");

        assertEquals(expectedOutput, actualOutput);
    }
}
