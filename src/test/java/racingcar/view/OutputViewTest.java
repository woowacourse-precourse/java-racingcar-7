package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    @Test
    void printRaceProgress() {
        // Given
        List<Car> cars = Arrays.asList(
                new Car("pobi"),
                new Car("woni")
        );

        cars.get(0).move(4);
        cars.get(0).move(4);
        cars.get(0).move(4);

        cars.get(1).move(4);
        cars.get(1).move(4);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        OutputView outputView = new OutputView();

        outputView.printRaceProgress(cars);

        String expectedOutput = "pobi : ---\n" +
                "woni : --\n\n";
        assertThat(outputStream.toString()).isEqualTo(expectedOutput);

        System.setOut(System.out);
    }
}
