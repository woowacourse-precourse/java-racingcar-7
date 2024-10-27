package racingcar.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @DisplayName("car 객체 생성")
    @Nested
    class CarNameTest {
        @DisplayName("car 생성 성공")
        @ParameterizedTest
        @ValueSource(strings = {"name", "pobi", "1"})
        void carNameSuccess(String input) {
            //when
            Car car = new Car(input);
            //Then
            assertThat(car.getName()).isEqualTo(input);

        }

        @DisplayName("car 생성시 이름 예외 처리 테스트")
        @ParameterizedTest
        @NullSource
        @ValueSource(strings = {"longName", "", "  "})
        void carNameException(String input) {
            //when && then
            assertThrows(IllegalArgumentException.class, () -> {
                new Car(input);
            });
        }
    }

    @DisplayName("car move 로직")
    @Nested
    class CarMoveTest {
        private static final int MOVING_FORWARD = 4;
        private static final int STOP = 3;
        Car car;
        MoveStrategy moveStrategy;

        @BeforeEach
        void initCarMoveTest() {
            car = new Car("test");
            moveStrategy = new RandomMoveStrategy();
        }

        @DisplayName("car 이동 조건 만족")
        @Test
        void carMoveOnePoint() {
            //when
            assertRandomNumberInRangeTest(() -> {
                car.move(moveStrategy);
                ;
            }, MOVING_FORWARD);
            //then
            assertThat(car.getPosition()).isEqualTo(1);
        }

        @DisplayName("car 이동 조건 만족x")
        @Test
        void carMoveZeroPoint() {
            //when
            assertRandomNumberInRangeTest(() -> {
                car.move(moveStrategy);
                ;
            }, STOP);
            //then
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }
}
