package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameLogicTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Car car;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        car = new Car("Alice");
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void 랜덤_4이상_숫자() {
        car.advance();
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));

        assertThat(outContent.toString().trim()).isEqualTo("Alice : -");
    }

    @Test
    void 랜덤_4미만_숫자() {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));

        assertThat(outContent.toString().trim()).isEqualTo("Alice :");
    }
}
