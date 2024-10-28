package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.moving.MovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.from("car1");
    }

    @Test
    @DisplayName("Car의 이름을 반환하는지 확인")
    void 자동차_이름_반환_확인() {
        // given
        String expectedName = "car1";

        // when
        String actualName = car.getName();

        // then
        assertThat(actualName).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("초기 위치가 0인지 확인")
    void 초기_위치가_0인지_확인() {
        // given
        int initialPosition = 0;

        // when
        int actualPosition = car.getPositionDistance();

        // then
        assertThat(actualPosition).isEqualTo(initialPosition);
    }

    @Test
    @DisplayName("이동 가능한 경우 Car의 위치가 증가하는지 확인")
    void 이동_가능한_경우_위치가_증가하는지_확인() {
        // given
        MovingStrategy movableStrategy = () -> true;
        int initialPosition = car.getPositionDistance();

        // when
        car.move(movableStrategy);
        int newPosition = car.getPositionDistance();

        // then
        assertThat(newPosition).isEqualTo(initialPosition + 1);
    }

    @Test
    @DisplayName("이동 불가능한 경우 Car의 위치가 변하지 않는지 확인")
    void 이동_불가능한_경우_위치가_변하지_않는지_확인() {
        // given
        MovingStrategy notMovableStrategy = () -> false;
        int initialPosition = car.getPositionDistance();

        // when
        car.move(notMovableStrategy);
        int newPosition = car.getPositionDistance();

        // then
        assertThat(newPosition).isEqualTo(initialPosition);
    }

    @ParameterizedTest
    @DisplayName("Car의 현재 위치 형식을 올바르게 반환하는지 확인")
    @ValueSource(strings = {"car1", "car2", "car3"})
    void 현재_위치_형식을_올바르게_반환하는지_확인(String carName) {
        // given
        Car car = Car.from(carName);
        String expectedFormat = carName + " : " + car.getPosition().getPosition();

        // when
        String actualFormat = car.currentPositionFormat();

        // then
        assertThat(actualFormat).isEqualTo(expectedFormat);
    }
}