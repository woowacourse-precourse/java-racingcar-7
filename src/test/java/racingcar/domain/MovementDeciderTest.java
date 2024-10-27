package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("[MovementDecider Test]")
public class MovementDeciderTest {
    private static final int MOVING = 4;
    private static final int STOP = 3;

    @Nested
    @DisplayName("생성된 숫자에 따라 옳바른 값을 리턴하는 지 검증한다")
    class validateDecision{

        @Test
        @DisplayName("전진 조건에 부합하는 숫자가 생성되면 true를 리턴한다")
        void Given_MovableCondition_When_validateMovement_Then_ReturnTrue() {
            assertRandomNumberInRangeTest(
                    ()->{
                        MovementDecider movementDecider = new MovementDecider();
                        assertThat(movementDecider.makeDecision()).isEqualTo(true);
                    },
                    MOVING
            );
        }

        @Test
        @DisplayName("전진 조건에 부합하지 않는 숫자가 생성되면 false를 리턴한다")
        void Given_StopCondition_When_validateMovement_Then_ReturnFalse() {
            assertRandomNumberInRangeTest(
                    ()->{
                        MovementDecider movementDecider = new MovementDecider();
                        assertThat(movementDecider.makeDecision()).isEqualTo(false);
                    },
                    STOP
            );
        }


    }


}
