package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @Test
    void printRaceProgress() {
        // Given
        List<Car> cars = Arrays.asList(
                new Car("pobi"),
                new Car("woni")
        );
        cars.get(0).move(3);
        cars.get(1).move(2);

        // Capturing output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        OutputView outputView = new OutputView();

        // When
        outputView.printRaceProgress(cars);

        // Then
        String expectedOutput = "pobi : ---\n" +
                "woni : --\n\n";
        assertThat(outputStream.toString()).isEqualTo(expectedOutput);

        // Reset the standard output
        System.setOut(System.out);
    }
}