package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.random.CarStateNumber;
import racingcar.domain.random.RandomNumberGenerator;

@SuppressWarnings("NonAsciiCharacters")
class CarTest {

    private CarName carName;
    private RandomNumberGenerator random;
    private Car car;

    @BeforeEach
    void setUp() {
        carName = new CarName("pobi");
        car = new Car(carName);
        random = new CarStateNumber();
    }

    @Test
    void 자동차를_생성한다() {
        // given
        int expectedPosition = 0;

        // when & then
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
        assertThat(car.getCarName()).isEqualTo(carName);
    }

    @Test
    void 자동차를_움직인다() {
        // given
        int expectedPosition = 1;

        // when
        car.moveCar(random.generateRandomNumber());

        // then
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @Test
    void 자동차를_두_번_움직인다() {
        // given
        int expectedPosition = 2;

        // when
        car.moveCar(random.generateRandomNumber());
        car.moveCar(random.generateRandomNumber());

        // then
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @Test
    void 조건을_만족하지_않을_경우_자동차는_움직이지_않는다() {
        // given
        int randomNumber = 3;
        int expectedPosition = 0;

        // when
        car.moveCar(randomNumber);

        // then
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }
}
