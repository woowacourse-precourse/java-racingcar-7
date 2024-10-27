package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @Test
    void 이동_횟수_확인() {
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @Test
    void 자동차_이름_확인() {
        assertThat(car.getName()).isEqualTo("test");
    }

    @Test
    void 자동차_이동() {
        for (int i = 0; i < 5; i++) {
            car.move();
        }
        assertThat(car.getMoveCount()).isEqualTo(5);
    }

    @Test
    void 입력받은_이름_리스트로_자동차_생성() {
        List<Car> cars = List.of(
            new Car("test1"),
            new Car("test2"));

        List<Car> result = Car.createCarsByName(List.of("test1", "test2"));

        assertThat(result)
            .usingRecursiveComparison()
            .isEqualTo(cars);
    }
}