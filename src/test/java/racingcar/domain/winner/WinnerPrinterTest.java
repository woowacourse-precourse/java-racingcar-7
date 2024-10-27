package racingcar.domain.winner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.entity.Car;
import racingcar.domain.road.entity.Road;
import racingcar.domain.winner.entity.Winner;
import racingcar.domain.winner.service.WinnerPrinter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerPrinterTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private WinnerPrinter winnerPrinter;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
        winnerPrinter = new WinnerPrinter();
    }

    @Test
    @DisplayName("우승자가 한 명일 때, 올바른 이름을 출력한다")
    void printSingleWinner() {
        // given
        Car car1 = new Car("car1");

        List<Car> carList = Arrays.asList(car1);

        // when
        winnerPrinter.printWinner(carList);

        // then
        String output = outputStream.toString().trim();
        assertThat(output).isEqualTo("최종 우승자 : car1");
    }

    @Test
    @DisplayName("우승자가 여러 명일 때, 올바른 이름을 출력한다")
    void printMultipleWinners() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> carList = Arrays.asList(car1, car2);

        // when
        winnerPrinter.printWinner(carList);

        // then
        String output = outputStream.toString().trim();
        assertThat(output).isEqualTo("최종 우승자 : car1, car2");
    }
}