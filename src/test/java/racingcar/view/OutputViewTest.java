package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class OutputViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private OutputView outputView;

    @BeforeEach
    public void setUp() {
        outputView = new OutputView();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void printRoundResultsHeader() {
        outputView.printRoundResultsHeader();
        String expected = "실행 결과" + System.lineSeparator();
        assertThat(outContent.toString()).contains(expected);
    }

    @Test
    void printRoundResults() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> cars = Arrays.asList(car1, car2);
        car1.setDistance(3);
        car2.setDistance(5);

        outputView.printRoundResults(cars);
        String expected = "car1 : ---" + System.lineSeparator() + "car2 : -----" + System.lineSeparator()
                + System.lineSeparator();
        assertThat(outContent.toString()).isEqualTo(expected);
    }

    @Test
    void printWinner() {
        String winners = "car1, car2";
        outputView.printWinner(winners);
        String expected = "최종 우승자 : " + winners;
        assertThat(outContent.toString()).contains(expected);
    }
}