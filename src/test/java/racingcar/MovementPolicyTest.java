package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import mock.ManualMockRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RandomNumberGenerator;
import racingcar.model.policy.MovementPolicy;
import racingcar.model.policy.RandomForwardMovementPolicy;

class MovementPolicyTest extends NsTest {

    @Test
    @DisplayName("0~9사이의 숫자 중 4미만의 숫자가 나온 경우 전진하지 않는다.")
    void 랜덤_전진_전략을_테스트1() {
        assertSimpleTest(() -> {
                    RandomNumberGenerator mockRandomGenerator = new ManualMockRandomNumberGenerator(2);
                    MovementPolicy movementPolicy = new RandomForwardMovementPolicy(mockRandomGenerator);
                    Car car = new Car("car");
                    movementPolicy.move(car);
                    assertThat(car.getPosition()).isZero();
                }
        );
    }

    @Test
    @DisplayName("0~9사이의 숫자 중 4이상의 숫자가 나온 경우 전진한다.")
    void 랜덤_전진_전략을_테스트2() {
        assertSimpleTest(() -> {
                    RandomNumberGenerator mockRandomGenerator = new ManualMockRandomNumberGenerator(5);
                    MovementPolicy movementPolicy = new RandomForwardMovementPolicy(mockRandomGenerator);
                    Car car = new Car("car");
                    movementPolicy.move(car);
                    assertThat(car.getPosition()).isEqualTo(1);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
