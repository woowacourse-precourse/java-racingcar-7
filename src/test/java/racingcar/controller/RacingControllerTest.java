package racingcar.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingControllerTest {

    private RacingController controller;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;
    private InputStream originalIn;

    @BeforeEach
    public void setUp() {
        controller = new RacingController();
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        originalIn = System.in;

        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void 자동차경주_진행_및_출력_검증_테스트() {
        String input = "pobi,woni,jun\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        controller.start();

        String output = outputStream.toString().trim();
        assertThat(output).contains("pobi : ", "woni : ", "jun : ");
        assertThat(output).contains("최종 우승자 : ");
    }

    @AfterEach
    public void tearDown() {
        Car.resetNames();
        System.setOut(originalOut);
        System.setIn(originalIn);
    }
}
