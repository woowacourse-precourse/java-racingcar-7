package racingcar.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    private final OutputView outputView = new OutputView();

    @Test
    void 각_과정_출력() {
        List<Car> carReportCards = new ArrayList<>();
        carReportCards.add(new Car("pobi", 3));
        carReportCards.add(new Car("woni", 3));
        carReportCards.get(0).getReportCard().set(0, false);
        carReportCards.get(0).getReportCard().set(1, true);
        carReportCards.get(0).getReportCard().set(2, true);
        carReportCards.get(1).getReportCard().set(0, true);
        carReportCards.get(1).getReportCard().set(1, true);
        carReportCards.get(1).getReportCard().set(2, true);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        outputView.printRace(carReportCards);

        String expectedOutput = "pobi : \nwoni : -\n\n" +
                "pobi : -\nwoni : --\n\n" +
                "pobi : --\nwoni : ---\n\n";

        String actualOutput = outputStream.toString().replace("\r\n", "\n").replace("\r", "\n");

        assertEquals(expectedOutput.replace("\r", "\n"), actualOutput);
        System.setOut(System.out);
    }

    @Test
    void 단독_우승자_출력() {
        List<Car> carReportCards = new ArrayList<>();
        carReportCards.add(new Car("pobi", 3));
        carReportCards.add(new Car("woni", 3));
        carReportCards.add(new Car("jun", 3));

        carReportCards.get(0).getReportCard().set(0, true);
        carReportCards.get(0).getReportCard().set(1, true);
        carReportCards.get(0).getReportCard().set(2, true);

        carReportCards.get(1).getReportCard().set(0, false);
        carReportCards.get(1).getReportCard().set(1, true);
        carReportCards.get(1).getReportCard().set(2, true);

        carReportCards.get(2).getReportCard().set(0, true);
        carReportCards.get(2).getReportCard().set(1, false);
        carReportCards.get(2).getReportCard().set(2, true);

        List<String> winners = outputView.calculateWinners(carReportCards);

        assertEquals(1, winners.size());
        assertTrue(winners.contains("pobi"));
    }

    @Test
    void 우승자가_여러명일경우_출력() {
        List<String> winners = List.of("jun", "pobi");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        outputView.printWinners(winners);

        String expectedOutput = "최종 우승자 : jun, pobi";
        assertEquals(expectedOutput, outputStream.toString().trim());

        System.setOut(System.out);
    }


}
