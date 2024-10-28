package racingcar.view.impl;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.common.constant.OutputMessage.OUTPUT_ROUND_RESULT;
import static racingcar.common.constant.OutputMessage.OUTPUT_WINNER;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("라운드_결과_문자열_표시_테스트")
    void testDisplayRoundResultString() {
        assertSimpleTest(() -> {
            consoleOutputView.displayRoundResultString();

            String expectedOutput = System.lineSeparator() + OUTPUT_ROUND_RESULT.getMessage();
            assertEquals(expectedOutput.trim(), outputStream.toString().trim());
        });
    }

    @Test
    @DisplayName("각_라운드_상태_표시_테스트")
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
    @DisplayName("자동차_경주_우승자_표시_테스트")
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