package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    @Test
    void 우승자_한명_테스트() {
        // Given
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");

        pobi.setPosition(5);
        woni.setPosition(3);
        jun.setPosition(4);

        List<Car> cars = Arrays.asList(pobi, woni, jun);
        RacingGame racingGame = new RacingGame(cars);

        // When
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
//        racingGame.printWinners();
        String result = outContent.toString();

        // Then
        assertTrue(result.contains("pobi"), "우승자는 pobi");
        assertFalse(result.contains("woni"), "woni는 우승자 X");
        assertFalse(result.contains("jun"), "jun은 우승자 X");
    }

    @Test
    void 우승자_여러명_테스트() {
        // Given
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");

        pobi.setPosition(5);
        woni.setPosition(3);
        jun.setPosition(5);

        List<Car> cars = Arrays.asList(pobi, woni, jun);
        RacingGame racingGame = new RacingGame(cars);

        // When
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
//        racingGame.printWinners();
        String result = outContent.toString();

        // Then
        assertTrue(result.contains("pobi") && result.contains("jun"), "공동 우승자 pobi, jun");
        assertFalse(result.contains("woni"), "woni는 우승자가 아닙니다.");
    }
}
