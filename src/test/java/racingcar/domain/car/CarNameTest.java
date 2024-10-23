package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class CarNameTest {
    @Test
    @DisplayName("빈문자열을 통해 생성시 IllegalArugmentException을 반환하는지 확인")
    void testEmptyStringThrowIllegalArgumentException() {
        String emptyString = "";

        assertThatThrownBy(()-> CarName.of(emptyString)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백 문자열을 통해 생성시 IllegalArugmentException을 반환하는지 확인")
    void testBlankThrowIllegalArgumentException() {
        String blank = " ";

        assertThatThrownBy(()->CarName.of(blank)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("5자보다 긴문자열을 통해 생성시 IllegalArugmentException을 반환하는지 확인")
    void testTooLongIdentifierThrowIllegalArgumentException() {
        String tooLongIdentifier = "123456";

        assertThatThrownBy(()->CarName.of(tooLongIdentifier)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("적절한 identifer를 통해 생성시 예외를 던지지 않는지 확인")
    @MethodSource("generateLegalIdentifierString")
    void testNotThrowIllegalArgumentException(String legalIdentifier) {
        assertThatNoException().isThrownBy(()->CarName.of(legalIdentifier));
    }

    private static Stream<Arguments> generateLegalIdentifierString() {
        return Stream.of(
                Arguments.of("1"),
                Arguments.of("12345")
        );
    }

    @Test
    @DisplayName("동일한 문자열로 생성한 객체가 equals를 true로 반환하는지 확인")
    void testEquals() {
        String sameIdentifier = "same";
        CarName carName = CarName.of(sameIdentifier);
        CarName another = CarName.of(sameIdentifier);

        assertThat(carName).isEqualTo(another);
    }

    @Test
    @DisplayName("동일한 문자열로 생성한 객체가 동일한 hashcode를 반환하는지 확인")
    void testHashCode() {
        String sameIdentifier = "same";
        CarName carName = CarName.of(sameIdentifier);
        CarName another = CarName.of(sameIdentifier);

        assertThat(carName).hasSameHashCodeAs(another);
    }
}