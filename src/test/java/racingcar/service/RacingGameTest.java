package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
    }

    @Test
    @DisplayName("게임 단판 실행")
    void testStartRace() {
        List<Car> cars = List.of(new Car("pobi"), new Car("woni"), new Car("java"));
        List<Integer> accelerators = List.of(5, 3, 4);

        racingGame.startRace(cars, accelerators);

        assertEquals(1, cars.get(0).currentPosition());
        assertEquals(0, cars.get(1).currentPosition());
        assertEquals(1, cars.get(2).currentPosition());
    }

    @Test
    @DisplayName("findWinner 승자 찾기")
    void testFindeWinner() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("java");

        car1.move();
        car3.move();
        car3.move();

        List<Car> cars = List.of(car1, car2, car3);

        List<String> winners = racingGame.findWinner(cars);

        assertEquals(1, winners.size());
        assertEquals("java", winners.getFirst());
    }
}
