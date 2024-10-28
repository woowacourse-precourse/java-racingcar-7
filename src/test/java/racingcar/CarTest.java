package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("자동차 생성 시 이름과 초기 위치가 올바른지 테스트")
    void testCarCreation() {
        String name = "Alpha";

        Car car = new Car(name);

        assertThat(car.currentName()).isEqualTo("Alpha");
        assertThat(car.currentPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("입력한 자동차 이름 목록을 통해 Car 객체가 올바르게 생성되는지 테스트")
    void testCreateCars() {
        List<String> carNames = List.of("Alpha", "Bravo", "Choco");

        List<Car> cars = Car.createCars(carNames);

        assertThat(cars).hasSize(3);
        assertThat(cars).extracting(Car::currentName).containsExactly("Alpha", "Bravo", "Choco");
    }

    @Test
    @DisplayName("정해진 값에 따라 자동차가 전진 혹은 정지하는지 테스트")
    void testCarMove() {
        Car car1 = new Car("Bravo");
        assertRandomNumberInRangeTest(() -> {
            car1.move();
            assertThat(car1.currentPosition()).isEqualTo(1);
        }, MOVING_FORWARD);

        Car car2 = new Car("Choco");
        assertRandomNumberInRangeTest(() -> {
            car2.move();
            assertThat(car2.currentPosition()).isEqualTo(0);
        }, STOP);
    }
}
