package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.model.RacingGameTest.FixedMoveStrategy;
import racingcar.model.car.Car;
import racingcar.model.car.MoveStrategy;
import racingcar.model.car.RandomMoveStrategy;

class CarTest {
    public static class FixedStopStrategy implements MoveStrategy {
        @Override
        public boolean canMove() {
            return false;
        }
    }

    private Car createCar(String carName) {
        return new Car(carName, new RandomMoveStrategy());
    }

    @Test
    void 이름사이에_공백포함시_예외() {
        // given
        String carName = "정 년이";

        // when
        // then
        assertThatThrownBy(() -> createCar(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름에 공백이 포함될 수 없습니다.");
    }

    @Test
    void 한글_영어만_자동차이름으로_성공() {
        // given
        String carName = "정년이";

        // when
        // then
        assertThat(createCar(carName).getCarName()).isEqualTo(carName);
    }

    @Test
    void 한글_영어만_자동차이름으로_실패() {
        // given
        String carName = "123";

        // when
        // then
        assertThatThrownBy(() -> createCar(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 한글과 영어만 포함해야합니다.");
    }

    @Test
    void 자동차이름은_5글자_이하일때_성공() {
        // given
        String carName = "햇빛";

        // when
        // then
        assertThat(createCar(carName).getCarName()).hasSameSizeAs(carName);
    }

    @Test
    void 자동차이름은_5글자_초과일때_실패() {
        // given
        String carName = "미스터션샤인";

        // when
        // then
        assertThatThrownBy(() -> createCar(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    void 자동차가_이동() {
        // given
        String carName = "볼보";

        // when
        Car car = new Car(carName, new FixedMoveStrategy());
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차가_이동하지_않음() {
        // given
        String carName = "볼보";

        // when
        Car car = new Car(carName, new FixedStopStrategy());
        car.move();

        // then
        assertThat(car.getPosition()).isZero();
    }
}
