package racingcar.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    private final OutputView outputView = new OutputView();

    @Test
    void testPrintReportCards() {
        Map<String, boolean[]> carReportCards = new HashMap<>();
        carReportCards.put("pobi", new boolean[]{true, true, false, true, false});
        carReportCards.put("woni", new boolean[]{false, false, true, true, true});
        int tryTimes = 5;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        outputView.printReportCards(carReportCards, tryTimes);

        String expectedOutput = "pobi : -\nwoni : \n\n" +
                "pobi : --\nwoni : \n\n" +
                "pobi : --\nwoni : -\n\n" +
                "pobi : ---\nwoni : --\n\n" +
                "pobi : ---\nwoni : ---\n\n";

        String actualOutput = outputStream.toString().replace("\r\n", "\n").replace("\r", "\n");

        assertEquals(expectedOutput.replace("\r", "\n"), actualOutput);
        System.setOut(System.out);
    }

    @Test
    void testCalculateWinners() {
        Map<String, boolean[]> carReportCards = new HashMap<>();
        carReportCards.put("pobi", new boolean[]{true, true, false, true, false});
        carReportCards.put("woni", new boolean[]{false, false, true, true, true});
        carReportCards.put("jun", new boolean[]{true, true, true, false, true});

        List<String> winners = outputView.calculateWinners(carReportCards);

        assertEquals(1, winners.size());
        assertTrue(winners.contains("jun"));
    }

    @Test
    void testPrintWinners() {
        List<String> winners = List.of("jun", "pobi");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        outputView.printWinners(winners);

        String expectedOutput = "최종 우승자 : jun, pobi";
        assertEquals(expectedOutput, outputStream.toString().trim());

        System.setOut(System.out);
    }

    @Test
    void testPrintWinners_EmptyList() {
        List<String> winners = List.of();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        outputView.printWinners(winners);

        assertEquals("", outputStream.toString().trim());
        System.setOut(System.out);
    }
}