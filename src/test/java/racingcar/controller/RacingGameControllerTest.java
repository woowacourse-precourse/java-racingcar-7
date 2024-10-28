package racingcar.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingGameControllerTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void run을_test하는_함수() {
        String input = "Car1,Car2,Car3\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        RacingGameController.run();

        String output = outputStream.toString();
        assertTrue(output.contains("최종 우승자 : "));
    }
}