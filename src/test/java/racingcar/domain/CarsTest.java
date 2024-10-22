package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ExceptionMessage.DUPLICATE_CARS;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CarsTest {
    @ParameterizedTest
    @DisplayName("중복된 자동차 이름 테스트")
    @MethodSource("makeDuplicateNames")
    void checkDuplicateCars_Test(String[] text) {
        // expected
        assertThatThrownBy(() -> new Cars(List.of(text)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_CARS.getMessage());
    }

    public static Stream<Arguments> makeDuplicateNames() {
        return Stream.of(
                Arguments.of((Object) new String[]{"carA", "carB", "carA"}),
                Arguments.of((Object) new String[]{"a", "b", "b", "b"})
        );
    }
}
