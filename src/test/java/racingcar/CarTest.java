package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import racingcar.util.TestMoveStrategies.AlwaysMoveStrategy;
import racingcar.util.TestMoveStrategies.NeverMoveStrategy;

class CarTest {

    @Test
    void 자동차의_초기위치는_0이다() {
        Car car = new Car("테스트카", new AlwaysMoveStrategy());
        assertEquals(0, car.getPosition());
    }

    @Test
    void 자동차는_전진_조건이_참일_때_1만큼_이동한다() {
        Car car = new Car("테스트카", new AlwaysMoveStrategy());
        int initialPosition = car.getPosition();

        car.move();
        assertEquals(initialPosition + 1, car.getPosition(), "자동차는 1만큼 이동해야 합니다.");
    }

    @Test
    void 자동차는_전진_조건이_거짓일_때_이동하지_않는다() {
        Car car = new Car("테스트카", new NeverMoveStrategy());
        int initialPosition = car.getPosition();

        car.move();
        assertEquals(initialPosition, car.getPosition(), "자동차는 이동하지 않아야 합니다.");
    }

    @Test
    void 자동차는_여러번_전진할_때_위치가_정확히_증가한다() {
        Car car = new Car("테스트카", new AlwaysMoveStrategy());
        car.move();
        car.move();
        car.move();
        assertEquals(3, car.getPosition(), "자동차는 3번 이동 후 위치가 3이어야 합니다.");
    }
}
