package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @DisplayName("자동차를 이동 전략에 따라 움직일 수 있다.")
    @CsvSource({
            "false, 0",
            "true, 1"
    })
    @ParameterizedTest
    void move(boolean isMovable, int expected) {
        //given
        CarName carName = new CarName("lee");
        MovementStrategy movementStrategy = () -> isMovable;
        Car car = new Car(carName, movementStrategy);

        //when
        car.move();

        //then
        CarStatus status = car.getStatus();
        assertThat(status).isEqualTo(new CarStatus("lee", expected));
    }
}