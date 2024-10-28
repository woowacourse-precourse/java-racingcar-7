package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Winners;

public class OutputProcessorTest {

    private OutputProcessor outputProcessor;

    @BeforeEach
    public void setUp() {
        outputProcessor = new OutputProcessor();
    }

    @Test
    public void 자동차_리스트_출력_형식_확인() {
        Car car1 = Car.of("car1", 3);
        Car car2 = Car.of("car2", 2);
        Cars cars = Cars.of(List.of(car1, car2));

        String result = outputProcessor.formatCars(cars);

        String expected = "car1 : ---\ncar2 : --\n";
        assertEquals(expected, result);
    }

    @Test
    public void 우승자_리스트_출력_형식_확인() {
        Car car1 = Car.of("car1", 5);
        Car car2 = Car.of("car2", 5);
        Cars cars = Cars.of(List.of(car1, car2));
        Winners winners = Winners.from(cars);

        String result = outputProcessor.formatWinners(winners);

        String expected = Message.FINAL_WINNER + "car1, car2";
        assertEquals(expected, result);
    }

    @Test
    public void 단일_우승자_출력_형식_확인() {
        Car car1 = Car.of("car1", 5);
        Car car2 = Car.of("car2", 3);
        Cars cars = Cars.of(List.of(car1, car2));
        Winners winners = Winners.from(cars);

        String result = outputProcessor.formatWinners(winners);

        String expected = Message.FINAL_WINNER + "car1";
        assertEquals(expected, result);
    }
}
