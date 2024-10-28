package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import movement.CarMovementHandler;
import movement.MovementHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(List.of("pobi", "woni", "jun"));
    }

    @Test
    void testMoveAll() {
        List<Integer> initialPositions = cars.getCars().stream()
                .map(Car::getPosition)
                .toList();

        MovementHandler randomNumberHandler = new CarMovementHandler();
        cars.moveAll(randomNumberHandler);

        for (int i = 0; i < cars.getCars().size(); i++) {
            int initialPosition = initialPositions.get(i);
            int newPosition = cars.getCars().get(i).getPosition();
            assertThat(newPosition).isGreaterThanOrEqualTo(initialPosition);
        }
    }

    @Test
    void testGetWinners() {
        for (int i = 0; i < 2; i++) {
            cars.getCars().get(0).moveForward();
        }
        for (int i = 0; i < 2; i++) {
            cars.getCars().get(1).moveForward();
        }
        for (int i = 0; i < 1; i++) {
            cars.getCars().get(2).moveForward();
        }

        List<String> winners = cars.getWinners();

        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni");
    }
}
