package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.WinnerCalculator;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinnerCalculatorTest {
    @Test
    void 승자를_정확히_계산하는지_테스트() {
        Car car1 = new Car("Car1");
        car1.move();
        car1.move();

        Car car2 = new Car("Car2");
        car2.move();

        Car car3 = new Car("Car3");
        car3.move();
        car3.move();

        List<Car> racingCarList = Arrays.asList(car1, car2, car3);

        WinnerCalculator winnerCalculator = new WinnerCalculator(racingCarList);
        List<String> winners = winnerCalculator.getWinner();

        List<String> expectedWinners = Arrays.asList("Car1", "Car3");
        assertEquals(expectedWinners, winners, "Car1과 Car3이 최종 우승자임");
    }
}
