package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @DisplayName("각 라운드의 결과를 콘솔창에 출력한다.")
    @Test
    void printRoundResults() {
        // given
        List<Car> cars = Arrays.asList(
                new Car("Car1", () -> true),
                new Car("Car2", () -> false),
                new Car("Car3", () -> true)
        );

        cars.get(0).move();
        cars.get(2).move();

        // when
        OutputView.printRoundResults(cars);

        // then
        String expectedOutput = "Car1 : -\nCar2 : \nCar3 : -\n\n";
        assertThat(outputStream.toString()).isEqualTo(expectedOutput);
    }

    @DisplayName("우승자를 콘솔창에 출력한다.")
    @Test
    void printWinners() {
        // given
        List<Car> winners = Arrays.asList(
                new Car("Car1", () -> true),
                new Car("Car2", () -> true)
        );

        // when
        OutputView.printWinners(winners);

        // then
        String expectedOutput = "최종 우승자 : Car1, Car2\n";
        assertThat(outputStream.toString()).isEqualTo(expectedOutput);
    }
}