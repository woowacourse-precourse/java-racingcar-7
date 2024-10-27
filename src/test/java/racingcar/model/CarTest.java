package racingcar.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

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
            //given
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
            //given
            //when && then
            assertThrows(IllegalArgumentException.class, () -> {
                new Car(input);
            });
        }
    }

    @DisplayName("car move 로직")
    @Nested
    class CarMoveTest {
        Car car;

        @BeforeEach
        void initCarMoveTest() {
            car = new Car("test");
        }

        @DisplayName("car 이동 조건 만족")
        @Test
        void carMoveOnePoint() {
            //given
            MoveStrategy moveStrategy = () -> true;
            //when
            car.move(moveStrategy);
            //then
            assertThat(car.getPosition()).isEqualTo(1);
        }

        @DisplayName("car 이동 조건 만족x")
        @Test
        void carMoveZeroPoint() {
            //given
            MoveStrategy moveStrategy = () -> false;
            //when
            car.move(moveStrategy);
            //then
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }
}
