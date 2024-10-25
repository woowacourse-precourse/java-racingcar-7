package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        Car car1 = new Car("car1", 3);
        Car car2 = new Car("car2", 5);
        Car car3 = new Car("car3", 5);
        cars = new Cars(List.of(car1, car2, car3));
    }

    @Test
    @DisplayName("자동차 이름 리스트로 Cars 객체 생성 테스트")
    void ofTest() {
        List<String> carNames = List.of("carA", "carB", "carC");

        Cars cars = Cars.of(carNames);

        assertThat(cars.getCars()).hasSize(3);
        assertThat(cars.getCars().get(0).getName()).isEqualTo("carA");
        assertThat(cars.getCars().get(1).getName()).isEqualTo("carB");
        assertThat(cars.getCars().get(2).getName()).isEqualTo("carC");
    }
}
