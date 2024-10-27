package racingcar.output;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

class ConsoleOutputManagerTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private ConsoleOutputManager consoleOutputManager;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
        consoleOutputManager = new ConsoleOutputManager();
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void 자동차_위치를_정상적으로_출력한다() {
        // given
        List<Car> cars = List.of(new Car("car1"), new Car("car2"), new Car("car3"));
        cars.get(0).move();
        cars.get(1).move();
        cars.get(1).move();

        // when
        consoleOutputManager.displayPosition(cars);

        // then
        String expectedOutput = "car1 : -\n" +
                "car2 : --\n" +
                "car3 : \n";
        assertThat(outputStream.toString().trim()).isEqualTo(expectedOutput.trim());
    }

    @Test
    void 우승자를_정상적으로_출력한다() {
        // given
        List<Car> winners = List.of(new Car("car1"), new Car("car2"));

        // when
        consoleOutputManager.displayWinners(winners);

        // then
        String expectedOutput = "최종 우승자 : car1, car2";
        assertThat(outputStream.toString().trim()).isEqualTo(expectedOutput.trim());
    }

    @Test
    void 에러_메시지를_정상적으로_출력한다() {
        // given
        String errorMessage = "에러 발생";

        // when
        consoleOutputManager.displayError(errorMessage);

        // then
        assertThat(outputStream.toString().trim()).isEqualTo(errorMessage);
    }
}
