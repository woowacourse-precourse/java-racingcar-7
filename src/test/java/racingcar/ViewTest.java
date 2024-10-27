package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ViewTest {
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;
    private View view;

    @BeforeEach
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        view = new View();
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void 실행_결과는_자동차_이름_입력순으로_보여준다() {
        Map<String, StringBuilder> roundResult = new LinkedHashMap<>();
        roundResult.put("test1", new StringBuilder("-"));
        roundResult.put("test2", new StringBuilder("--"));
        roundResult.put("test3", new StringBuilder("---"));

        view.print(roundResult);

        String expectedOutput = "test1 : -\ntest2 : --\ntest3 : ---\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    void 우승자가_여러명일_경우_쉼표를_통해_구분한다() {
        List<String> winners = new ArrayList<>();
        winners.add("test1");
        winners.add("test2");
        winners.add("test3");

        view.print(winners);

        String expectedOutput = "최종 우승자 : test1, test2, test3";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}
