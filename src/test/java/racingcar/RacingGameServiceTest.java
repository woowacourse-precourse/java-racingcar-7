package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.RacingGameService;

public class RacingGameServiceTest {

    private RacingGameService racingGameService = new RacingGameService();

    @Test
    @DisplayName("라운드별 자동차 이동 테스트")
    void roundPlayTest() {
        List<Car> cars = Stream.of("car1", "car2", "car3")
            .map(Car::new)
            .collect(Collectors.toList());
        int initialPositionCar1 = cars.get(0).getPosition();

        racingGameService.play(cars);

        assertTrue(cars.get(0).getPosition() >= initialPositionCar1);
    }

    @Test
    @DisplayName("우승자를 정상적으로 찾는다")
    void findWinner() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        car1.moveTry(5);
        car2.moveTry(5);
        car2.moveTry(5);
        car3.moveTry(5);

        List<Car> cars = List.of(car1, car2, car3);
        List<Car> winners = racingGameService.findWinner(cars);

        assertEquals(1, winners.size());
        assertEquals("car2", winners.get(0).getName());
    }

    @Test
    @DisplayName("모든 자동차가 같은 위치일 경우 공동 우승자를 찾는다")
    void findMultipleWinners() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        car1.moveTry(5);
        car2.moveTry(5);

        List<Car> cars = List.of(car1, car2);
        List<Car> winners = racingGameService.findWinner(cars);

        assertEquals(2, winners.size());
        assertTrue(winners.stream().anyMatch(car -> car.getName().equals("car1")));
        assertTrue(winners.stream().anyMatch(car -> car.getName().equals("car2")));
    }
}
