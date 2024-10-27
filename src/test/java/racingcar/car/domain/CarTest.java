package racingcar.car.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.global.util.ErrorMessage;
import racingcar.mock.FakeRandomHolder;

class CarTest {


    @Test
    @DisplayName("정상적으로 입력하면 Car객체가 만들어진다")
    void createNormal() throws Exception {
        // given
        Car car = new Car("Name");

        // when

        // then
        assertThat(car).isNotNull()
                .extracting("name", "move")
                .containsExactlyInAnyOrder("Name", 0);
    }

    @ParameterizedTest
    @DisplayName("이름의 길이가 1~5가 아니면 에러를 반환")
    @MethodSource("provideOutOfRangeNameLength")
    void OutOfRangeNameLength(String name) throws Exception {
        // then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NAME_FORMAT.getMessage());

    }

    private static Stream<Arguments> provideOutOfRangeNameLength() {
        return Stream.of(
                Arguments.arguments("123456"),
                Arguments.arguments("@"),
                Arguments.arguments("abcdfe"),
                Arguments.arguments("#"),
                Arguments.arguments("+"),
                Arguments.arguments("가가가가가갸"),
                Arguments.arguments("가나다ab1"),
                Arguments.arguments(""),
                Arguments.arguments(" ")
        );
    }

    @ParameterizedTest
    @DisplayName("이름이 영어, 숫자, 한글외에 다른 문자가 들어가면 에러를 반환")
    @MethodSource("provideInvalidFormat")
    void InvalidFormat(String name) throws Exception {
        // then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NAME_FORMAT.getMessage());

    }

    private static Stream<Arguments> provideInvalidFormat() {
        return Stream.of(
                Arguments.arguments("1a2s3~"),
                Arguments.arguments("a 45"),
                Arguments.arguments("qdcvz@"),
                Arguments.arguments("@@"),
                Arguments.arguments("$$$@"),
                Arguments.arguments("\\n"),
                Arguments.arguments("\\t"),
                Arguments.arguments("  ")
        );
    }

    @Test
    @DisplayName("car 클래스의 move를 호출하면 move에 1이 더해진다")
    void move() throws Exception {
        // given
        Car car = new Car("테스트");

        // when
        car.move();

        // then
        assertThat(car).isNotNull()
                .extracting("name", "move")
                .containsExactlyInAnyOrder("테스트", 1);
    }

}