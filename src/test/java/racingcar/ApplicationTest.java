package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Name;
import racingcar.domain.car.Position;
import racingcar.domain.car.Vehicle;
import racingcar.domain.strategy.RandomStrategy;

class ApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 자동차의_난수_전략이_4_미만을_생성하면_정지한다() {
        // given
        Name name = Name.from("A");
        Position position = Position.from(0);
        RandomStrategy doNotMove = RandomStrategy.from(STOP);
        // when
        Car car = Car.of(name, position, doNotMove);
        Vehicle notMovedCar = car.moveForwardRandomly();
        // then
        assertEquals(car, notMovedCar);
        assertEquals(car.getPosition(), notMovedCar.getPosition());
        assertEquals(car.getPosition().getValue(), notMovedCar.getPosition().getValue());
    }

    @Test
    void 자동차의_난수_전략이_4_이상을_생성하면_전진한다() {
        // given
        Name name = Name.from("A");
        Position position = Position.from(0);
        RandomStrategy move = RandomStrategy.from(MOVING_FORWARD);
        // when
        Car car = Car.of(name, position, move);
        Vehicle movedCar = car.moveForwardRandomly();
        // then
        assertNotEquals(car, movedCar);
        assertNotEquals(car.getPosition(), movedCar.getPosition());
        assertEquals(car.getPosition().getValue(), movedCar.getPosition().getValue() - 1);
    }
}
