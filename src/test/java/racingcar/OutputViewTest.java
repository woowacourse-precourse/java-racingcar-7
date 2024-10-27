package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    private OutputView outputView;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        System.setOut(new PrintStream(outputStreamCaptor));  // System.out을 캡처하도록
    }

    @Test
    void printResult_shouldPrintCarPositions() {
        // given
        Car car1 = new Car("CarA");
        Car car2 = new Car("CarB");
        for (int i = 0; i < 3; i++) {
            car1.incCurrentPos();
        }
        car2.incCurrentPos();
        List<Car> cars = Arrays.asList(car1, car2);

        // when
        outputView.printResult(cars);

        // then
        String expectedOutput = "CarA : ---\nCarB : -\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}
