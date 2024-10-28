package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Output output;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        output = new Output();
    }

    @Test
    void printExecutionResult_출력() {
        output.printExecutionResult();

        assertThat(outContent.toString().trim()).isEqualTo("실행 결과");
    }

    @Test
    void printRoundResult_출력() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        car1.move(4);
        car2.move(5);
        Cars cars = new Cars(List.of(car1, car2));
        output.printRoundResult(cars);
        String expectedOutput = "pobi : ----\ncrong : -----\n";
        assertThat(outContent.toString().trim()).isEqualTo(expectedOutput.trim());
    }
    @Test
    void printWinners_출력() {
        List<String> winners = List.of("pobi", "crong");
        output.printWinners(winners);
        assertThat(outContent.toString().trim()).isEqualTo("최종 우승자 : pobi, crong");
    }
}
