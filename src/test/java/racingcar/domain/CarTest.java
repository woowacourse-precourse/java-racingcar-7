package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarMovementPolicy;
import racingcar.model.DefaultCarMovementPolicy;
import racingcar.model.Name;

class CarTest {

    final CarMovementPolicy movementPolicy = new DefaultCarMovementPolicy();

    @Test
    @DisplayName("이름이 같다면 동일한 자동차여야 한다.")
    void sameNameCarTest() {
        // given
        Name name = Name.from("test");
        Car car = new Car(name, movementPolicy);
        Car sameCar = new Car(name, movementPolicy);

        // when, then
        assertThat(car).isEqualTo(sameCar);
    }

    @Test
    @DisplayName("이동 조건에 부합하면 자동차는 전진해야 한다.")
    void moveCarIfValidConditionToMoveTest() {
        // given
        Name name = Name.from("name");
        Car car = new Car(name, movementPolicy);

        // when
        int movementValue = 7;
        car.race(movementValue);

        // then
        assertThat(car.position()).isOne();
    }

    @Test
    @DisplayName("이동 조건에 부합하지 않다면 자동차는 정지해야 한다.")
    void stopCarIfInvalidConditiontToMoveest() {
        // given
        Name name = Name.from("name");
        Car car = new Car(name, movementPolicy);

        // when
        int movementValue = 2;
        car.race(movementValue);

        // then
        assertThat(car.position()).isZero();
    }

    @Test
    @DisplayName("같은 위치에 있는 자동차라면 참을 반환해야 한다.")
    void samePositionCarsTest() {
        // given
        Name pobi = Name.from("pobi");
        Name woni = Name.from("woni");

        Car pobiCar = new Car(pobi, movementPolicy);
        Car woniCar = new Car(woni, movementPolicy);

        // when, then
        assertThat(pobiCar.isSamePosition(woniCar)).isTrue();
    }

    @Test
    @DisplayName("다른 위치에 있는 자동차라면 거짓을 반환해야 한다.")
    void differentPositionCarsTest() {
        // given
        Name pobi = Name.from("pobi");
        Name woni = Name.from("woni");

        Car pobiCar = new Car(pobi, movementPolicy);
        Car woniCar = new Car(woni, movementPolicy);

        pobiCar.race(9);

        // when, then
        assertThat(pobiCar.isSamePosition(woniCar)).isFalse();
    }

}
