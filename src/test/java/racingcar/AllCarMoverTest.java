package racingcar;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AllCarMoverTest {

    private CarMover trueCarMover;
    private CarMover falseCarMover;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = List.of(
                new Car("a"),
                new Car("b")
        );

        trueCarMover = new CarMover(new TrueMockMovePolicy());
        falseCarMover = new CarMover(new FalseMockMovePolicy());
    }

    @Test
    @DisplayName("모든 차가 이동하는 경우 테스트")
    void 모든_차_이동_테스트() {
        // given
        AllCarMover allCarMover = new AllCarMover(trueCarMover);

        // when
        allCarMover.run(cars);

        // then
        assertThat(cars).allMatch(car -> car.getMoveCount() == 1);
    }

    @Test
    @DisplayName("모든 차가 이동하지 않는 경우 테스트")
    void 모든_차_정지_테스트() {
        // given
        AllCarMover allCarMover = new AllCarMover(falseCarMover);

        // when
        allCarMover.run(cars);

        // then
        assertThat(cars).allMatch(car -> car.getMoveCount() == 0);
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
