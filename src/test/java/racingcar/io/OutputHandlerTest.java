package racingcar.io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

class OutputHandlerTest {

    private final OutputHandler outputHandler = new OutputHandler();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void reset(){
        System.setOut(System.out);
        outputStream.reset();
    }

    @Test
    void printResult() {
        List<String> winners = List.of("car1", "2314", "$$@", "^-^");
        outputHandler.printResult(winners);

        String expectedOutput = "최종 우승자 : car1, 2314, $$@, ^-^\n";
        Assertions.assertThat(outputStream.toString()).isEqualTo(expectedOutput);
    }

    @Test
    void printStatus() {
        Car car1 = new Car("Car1", 0);
        Car car2 = new Car("Car2", 5);
        List<Car> cars = List.of(car1, car2);
        outputHandler.printStatus(cars);

        String expectedOutput = "실행 결과\nCar1 : \nCar2 : -----\n";
        Assertions.assertThat(outputStream.toString()).isEqualTo(expectedOutput);
    }
}