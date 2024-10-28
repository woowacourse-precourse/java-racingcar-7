package racingcar.result;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;

class ResultCalculatorTest {

    private final ResultCalculator calculator = new ResultCalculator();

    @Test
    void 우승자_결정_테스트() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        car1.move(5); // pobi 이동
        car2.move(3); // woni 이동 안 함

        List<String> winners = calculator.determineWinners(List.of(car1, car2));

        assertEquals(List.of("pobi"), winners);
    }
}
