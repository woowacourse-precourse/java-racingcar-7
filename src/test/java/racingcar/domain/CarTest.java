package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("Jiwoo", "--");
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 2, 1, 0})
    void 랜덤수가_3_이하인_경우_움직이지_않는다(int randomNum) {
        int originDist = car.getDistance();

        assertThat(car.act(randomNum).getDistance()).isEqualTo(originDist);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 8, 9})
    void 랜덤수가_4_이상인_경우_움직인다(int randomNum) {
        int originDist = car.getDistance();

        assertThat(car.act(randomNum).getDistance()).isEqualTo(originDist + 1);
    }
}