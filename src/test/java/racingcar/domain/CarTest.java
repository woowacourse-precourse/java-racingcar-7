package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class CarTest {


    @Nested
    @DisplayName("[자동차 - 검증 테스트]")
    class 경주_자동차_검증_테스트 {

        @ParameterizedTest(name = "({index}) {0}")
        @ValueSource(
                strings = {"car000", "abcdef", "a,.g'e"}
        )
        @DisplayName("이름 길이 초과 시, 예외 발생")
        void 이름_5자_초과한_경우_IllegalArgumentException을_발생시킨다(
                // given
                String overLengthName
        ) {
            // when & then
            assertThatThrownBy(() -> new Car(overLengthName))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

    @Nested
    @DisplayName("[자동차 - 기능 테스트]")
    class 경주_자동차_기능_테스트 {

        @Test
        @DisplayName("이름 조회")
        void getName_호출_시_자동차의_이름을_반환한다() {
            // given
            String expected = "test";
            Car testCar = new Car(expected);

            // when
            String compared = testCar.getName();

            // then
            assertThat(compared).isEqualTo(expected);
        }


        @Test
        @DisplayName("위치 조회")
        void getPosition_호출_시_자동차의_현재_위치를_반환한다() {
            // given
            Car testCar = new Car("test");

            // when
            testCar.move();

            // then
            long expected = 1;
            assertThat(testCar.getPosition()).isEqualTo(expected);
        }


        @ParameterizedTest(name = "({index}) {1} ==> {2}")
        @MethodSource("argumentsAboutCarAndMovingAndExpectedInformation")
        @DisplayName("자동차 상태 정보 조회")
        void getInformation_호출_시_자동차의_현재_상태_정보를_반환한다(
                // given
                Car givenCar, boolean isAbleToMove, String expected
        ) {
            // when
            if (isAbleToMove) {
                givenCar.move();
            }

            // then
            assertThat(givenCar.getInformation()).isEqualTo(expected);
        }
        static Stream<Arguments> argumentsAboutCarAndMovingAndExpectedInformation() {
            return Stream.of(
                    Arguments.of(new Car("test"), true, "test : -"),
                    Arguments.of(new Car("test"), false, "test : ")
            );
        }

    }

}