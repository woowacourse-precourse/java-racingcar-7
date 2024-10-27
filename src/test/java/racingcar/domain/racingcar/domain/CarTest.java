package racingcar.domain.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {


    @Nested
    @DisplayName("객체 생성 및 유효성 검증 테스트")
    class CreationAndValidationTests {

        @ParameterizedTest
        @ValueSource(strings = {"chi1", "chi2", "chi3"})
        @DisplayName("자동차 객체를 정상적으로 생성한다.")
        void createAndValidateDate(String name) {
            // when & then
            Assertions.assertThatNoException()
                    .isThrownBy(() -> Car.of(name));
        }

        @ParameterizedTest
        @ValueSource(strings = {"chichi", "++++++++", ""})
        @DisplayName("객체의 이름이 5를 초과하면 예외처리한다.")
        void checkCarName(String name) {
            // when & then
            assertThatThrownBy(() -> Car.of(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차의 이름이 적절하지 않습니다.");
        }
    }


    @Nested
    @DisplayName("객체 생성 및 유효성 검증 테스트")
    class CarMoveTests {

        @Test
        @DisplayName("랜덤 값이 4 이상이면 자동차가 전진한다")
        void carMove() {
            // given
            Car car = Car.of("car1");
            int initPosition = car.getPosition();

            // when
            car.move(4);

            // then
            assertEquals(initPosition + 1, car.getPosition());
        }

        @Test
        @DisplayName("랜덤 값이 4 미만이면 자동차가 정지한다")
        void carStopsWhenRandomValueIsLessThanFour() {
            // given
            Car car = Car.of("car1");
            int initPosition = car.getPosition();

            // when
            car.move(3);

            // then
            assertEquals(initPosition, car.getPosition());
        }

    }


}