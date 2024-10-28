package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void 자동차가_전진하는_경우_테스트() {
        Car car = new Car("pobi");
        int randomNumber = 4;
        car.decideToMove(randomNumber);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차가_멈추는_경우_테스트() {
        Car car = new Car("pobi");
        int randomNumber = 3;
        car.decideToMove(randomNumber);
        assertThat(car.getPosition()).isZero();
    }
}
