package racingcar.domain.mover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.mover.CarMover;
import racingcar.domain.mover.policy.MovePolicy;

import static org.assertj.core.api.Assertions.assertThat;

class CarMoverTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @Test
    void 전진정책을_항상_true를_반환하는_Mock_객체를_주입_전진성공() {
        // given
        CarMover carMover = new CarMover(new TrueMockMovePolicy());

        // when
        carMover.run(car);

        // then
        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @Test
    void 전진정책을_항상_false를_반환하는_Mock_객체를_주입_그대로정지() {
        // given
        CarMover carMover = new CarMover(new FalseMockMovePolicy());

        // when
        carMover.run(car);

        // then
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    static class TrueMockMovePolicy implements MovePolicy {
        @Override
        public boolean canMove() {
            return true;
        }
    }

    static class FalseMockMovePolicy implements MovePolicy {
        @Override
        public boolean canMove() {
            return false;
        }
    }

}
