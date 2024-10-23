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


        @ParameterizedTest(name = "({index}) {1} ==> {2}")
        @MethodSource("argumentsAboutCarAndMovingAndExpectedPosition")
        @DisplayName("위치 조회")
        void getPosition_호출_시_자동차의_현재_위치를_반환한다(
                // given
                Car testCar, long moveDistance, long expected
        ) {
            // when
            testCar.move(moveDistance);

            // then
            assertThat(testCar.getPosition()).isEqualTo(expected);
        }
        static Stream<Arguments> argumentsAboutCarAndMovingAndExpectedPosition() {
            return Stream.of(
                    Arguments.of(new Car("test"), 10, 10),
                    Arguments.of(new Car("test"), 0, 0),
                    Arguments.of(new Car("pobi"), 5, 5)
            );
        }

        @ParameterizedTest(name = "({index}) {1} ==> {2}")
        @MethodSource("argumentsAboutCarAndMovingAndExpectedInformation")
        @DisplayName("자동차 상태 정보 조회")
        void getInformation_호출_시_자동차의_현재_상태_정보를_반환한다(
                // given
                Car givenCar, long moveDistance, String expected
        ) {
            // when
            givenCar.move(moveDistance);

            // then
            assertThat(givenCar.getInformation()).isEqualTo(expected);
        }
        static Stream<Arguments> argumentsAboutCarAndMovingAndExpectedInformation() {
            return Stream.of(
                    Arguments.of(new Car("test"), 10, "test : ----------"),
                    Arguments.of(new Car("test"), 0, "test : "),
                    Arguments.of(new Car("pobi"), 5, "pobi : -----")
            );
        }

        @ParameterizedTest(name = "({index}) {0} ==> {1}")
        @ValueSource(
                longs = {10, 100, 1_000, 10_000, 100_000}
        )
        @DisplayName("이동")
        void move_호출_시_자동차가_이동하며_이동한만큼_현재_위치가_증가한다(
                long moveDistance
        ) {
            // given
            Car testCar = new Car("test");

            // when & then
            assertThatCode(() -> testCar.move(moveDistance))
                    .doesNotThrowAnyException();
            assertThat(testCar.getPosition()).isEqualTo(moveDistance);
        }

    }

}