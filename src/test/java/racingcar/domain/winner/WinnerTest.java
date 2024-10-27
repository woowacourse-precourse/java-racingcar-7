package racingcar.domain.winner;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarService;
import racingcar.util.RandomUtilTest;

class WinnerTest {

    private List<Car> cars;
    private CarService carService;
    private Winner winner;

    @BeforeEach
    void setUp() {
        this.cars = List.of(new Car("pobi"), new Car("won"), new Car("jun"));
        this.carService = new CarService(new RandomUtilTest(5));
        this.winner = new Winner();
    }

    @Test
    @DisplayName("한명의 사용자가 우승자인 경우")
    void getWinner() {
        // given

        // when
        carService.incrementMoveCount(cars.getFirst());
        String winners = winner.getWinners(cars);

        // then
        Assertions.assertEquals(winners, "pobi");
    }

    @Test
    @DisplayName("우승자가 여러명인 경우")
    void getWinners() {
        // given

        // when
        carService.incrementMoveCount(cars.getFirst());
        carService.incrementMoveCount(cars.getLast());
        String winners = winner.getWinners(cars);

        // then
        Assertions.assertEquals(winners, "pobi, jun");
    }
}