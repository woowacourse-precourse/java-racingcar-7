package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputViewTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private OutputView outputView;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
        outputView = new OutputView();
    }

    @AfterEach
    void restoreSystemOut() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("레이스 상태 출력 기능 테스트")
    void testPrintRaceStatus() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");

        pobi.moveIfPossible(4);
        pobi.moveIfPossible(4);
        pobi.moveIfPossible(4);
        woni.moveIfPossible(4);
        jun.moveIfPossible(4);
        jun.moveIfPossible(4);

        List<Car> cars = List.of(pobi, woni, jun);

        outputView.printRaceStatus(cars);

        String expectedOutput = "pobi : ---\nwoni : -\njun : --\n\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    @DisplayName("최종 우승자 출력 기능 테스트")
    void testPrintFinalWinners() {
        List<String> winners = List.of("pobi", "jun");

        outputView.printFinalWinners(winners);

        String expectedOutput = "최종 우승자 : pobi, jun";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }
}
