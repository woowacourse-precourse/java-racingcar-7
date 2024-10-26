package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class OutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final OutputView outputView = new OutputView();

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void printExecutionResultHeader() {
        outputView.printExecutionResultHeader();
        assertThat(output.toString()).isEqualTo("\n실행 결과\n");
    }

    @Test
    void printExecutionStatus() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", 2));
        cars.add(new Car("woni", 1));
        cars.add(new Car("jun", 2));

        outputView.printExecutionStatus(cars);
        assertThat(output.toString()).isEqualTo(
                "pobi : --\n"
                        + "woni : -\n"
                        + "jun : --\n\n");
    }

    @Test
    void printFinalWinner() {
        List<String> winners = new ArrayList<>();
        winners.add("pobi");
        winners.add("jun");

        outputView.printFinalWinner(winners);
        assertThat(output.toString()).isEqualTo("최종 우승자 : pobi, jun\n");
    }
}