package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

public class GameContextTest {
    private Car car1;
    private Car car2;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        car1 = new Car("pobi");
        car2 = new Car("woni");
        cars = List.of(car1, car2);
    }

    @Test
    void playGame_자동차이동_테스트() {
        Supplier<Integer> customSupplier = () -> 5;
        GameContext gameContext = new GameContext(cars, 3, customSupplier);

        gameContext.playGame();

        assertEquals(car1.getPosition(), 3);
        assertEquals(car2.getPosition(), 3);
    }

    @Test
    void playGame_자동차정지_테스트() {
        Supplier<Integer> customSupplier = () -> 3;
        GameContext gameContext = new GameContext(cars, 3, customSupplier);

        gameContext.playGame();

        assertEquals(car1.getPosition(), 0);
        assertEquals(car2.getPosition(), 0);
    }
}
