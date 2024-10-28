package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static util.Utils.MOVING_FORWARD;
import static util.Utils.STOP;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.model.policy.CarMovePolicy;
import racingcar.model.policy.MovementPolicy;
import racingcar.model.policy.RandomMoveCondition;

class ApplicationTest extends NsTest {

    private MovementPolicy movementPolicy;

    @BeforeEach
    void setUp() {
        movementPolicy = new CarMovePolicy(new RandomMoveCondition());
    }

    @Test
    void 레이싱_게임을_테스트한다() {
        assertRandomNumberInRangeTest(() -> {
                    run("car1,car2", "5");
                    assertThat(output()).contains(
                            "car1 :",
                            "car2 : -",

                            "car1 :",
                            "car2 : --",

                            "car1 : -",
                            "car2 : ---",

                            "car1 : --",
                            "car2 : ----",

                            "car1 : --",
                            "car2 : ----",

                            "최종 우승자 : car2");
                },
                STOP, MOVING_FORWARD,
                STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD,
                STOP, STOP
        );
    }

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
}
