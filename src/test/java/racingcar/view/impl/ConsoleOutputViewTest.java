package racingcar.view.impl;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.common.constant.OutputMessage.OUTPUT_ROUND_RESULT;
import static racingcar.common.constant.OutputMessage.OUTPUT_WINNER;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarDomain;
import racingcar.domain.CarDomains;

class ConsoleOutputViewTest {
    private ConsoleOutputView consoleOutputView;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        consoleOutputView = ConsoleOutputView.getInstance();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testDisplayRoundResultString() {
        assertSimpleTest(() -> {
            consoleOutputView.displayRoundResultString();

            String expectedOutput = System.lineSeparator() + OUTPUT_ROUND_RESULT.getMessage();
            assertEquals(expectedOutput.trim(), outputStream.toString().trim());
        });
    }

    @Test
    void testDisplayEachRoundStatus() {
        assertSimpleTest(() -> {
            CarDomain car1 = CarDomain.create("Car1", 2);
            CarDomain car2 = CarDomain.create("Car2", 3);
            CarDomains carDomains = CarDomains.create(Arrays.asList(car1, car2));

            consoleOutputView.displayEachRoundStatus(carDomains);

            String expectedOutput = "Car1 : --" + System.lineSeparator() +
                    "Car2 : ---" + System.lineSeparator();
            assertEquals(expectedOutput.trim(), outputStream.toString().trim());
        });
    }

    @Test
    void testDisplayCarRaceWinner() {
        assertSimpleTest(() -> {
            CarDomain winner1 = CarDomain.create("Car1", 5);
            CarDomain winner2 = CarDomain.create("Car2", 5);
            CarDomains winners = CarDomains.create(Arrays.asList(winner1, winner2));

            consoleOutputView.displayCarRaceWinner(winners);

            String expectedOutput = OUTPUT_WINNER.getMessage() + "Car1, Car2";
            assertEquals(expectedOutput, outputStream.toString().trim());
        });
    }
}