package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CountingWinnersTest {
    private final List<Car> testCars = new ArrayList<>();
    private final Utils utils = new Utils();

    @Test
    void 우승자가_한_명() {
        // Given
        Car car1 = new Car("Car1");
        for (int i = 0; i < 4; i++) {
            car1.moveOrStop(true);
        }
        testCars.add(car1);

        Car car2 = new Car("Car2");
        for (int i = 0; i < 7; i++) {
            car2.moveOrStop(true);
        }
        testCars.add(car2);

        Car car3 = new Car("Car3");
        for (int i = 0; i < 1; i++) {
            car3.moveOrStop(true);
        }
        testCars.add(car3);

        Car car4 = new Car("Car4");
        for (int i = 0; i < 4; i++) {
            car4.moveOrStop(true);
        }
        testCars.add(car4);

        Car car5 = new Car("Car5");
        for (int i = 0; i < 3; i++) {
            car5.moveOrStop(true);
        }
        testCars.add(car5);

        // When
        List<Car> result = utils.countWinners();

        // Then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.getFirst()).isEqualTo(car2);
    }

    @Test
    void 우승자가_여러_명() {
        // Given
        Car car1 = new Car("Car1");
        for (int i = 0; i < 4; i++) {
            car1.moveOrStop(true);
        }
        testCars.add(car1);

        Car car2 = new Car("Car2");
        for (int i = 0; i < 7; i++) {
            car2.moveOrStop(true);
        }
        testCars.add(car2);

        Car car3 = new Car("Car3");
        for (int i = 0; i < 1; i++) {
            car3.moveOrStop(true);
        }
        testCars.add(car3);

        Car car4 = new Car("Car4");
        for (int i = 0; i < 4; i++) {
            car4.moveOrStop(true);
        }
        testCars.add(car4);

        Car car5 = new Car("Car5");
        for (int i = 0; i < 7; i++) {
            car5.moveOrStop(true);
        }
        testCars.add(car5);

        Car car6 = new Car("Car6");
        for (int i = 0; i < 7; i++) {
            car6.moveOrStop(true);
        }
        testCars.add(car6);

        // When
        List<Car> result = utils.countWinners();

        // Then
        assertThat(result.size()).isEqualTo(3);
        assertThat(car2).isIn(result);
        assertThat(car5).isIn(result);
        assertThat(car6).isIn(result);
    }

    @Test
    void 모두의_전진_횟수_동일() {
        // Given
        Car car1 = new Car("Car1");
        for (int i = 0; i < 5; i++) {
            car1.moveOrStop(true);
        }
        testCars.add(car1);

        Car car2 = new Car("Car2");
        for (int i = 0; i < 5; i++) {
            car2.moveOrStop(true);
        }
        testCars.add(car2);

        Car car3 = new Car("Car3");
        for (int i = 0; i < 5; i++) {
            car3.moveOrStop(true);
        }
        testCars.add(car3);

        Car car4 = new Car("Car4");
        for (int i = 0; i < 5; i++) {
            car4.moveOrStop(true);
        }
        testCars.add(car4);

        Car car5 = new Car("Car5");
        for (int i = 0; i < 5; i++) {
            car5.moveOrStop(true);
        }
        testCars.add(car5);

        Car car6 = new Car("Car6");
        for (int i = 0; i < 5; i++) {
            car6.moveOrStop(true);
        }
        testCars.add(car6);

        // When
        List<Car> result = utils.countWinners();

        // Then
        assertThat(result.size()).isEqualTo(6);
        assertThat(car1).isIn(result);
        assertThat(car2).isIn(result);
        assertThat(car3).isIn(result);
        assertThat(car4).isIn(result);
        assertThat(car5).isIn(result);
        assertThat(car6).isIn(result);
    }

    @AfterEach
    void tearDown() {
        testCars.clear();
    }
}
