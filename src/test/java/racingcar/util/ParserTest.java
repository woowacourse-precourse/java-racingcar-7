package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ParserTest {

    @ParameterizedTest
    @MethodSource("provideCarNames")
    @DisplayName("사용자 입력 콤마로 split")
    void parseCarsTest(String input, List<String> expected) {
        assertThat(Parser.parseCars(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideCarNames() {
        return Stream.of(
                Arguments.of("polar,bear,pop,pep", List.of("polar", "bear", "pop", "pep")),
                Arguments.of("a,b,c,d", List.of("a", "b", "c", "d")),
                Arguments.of("apple,banana,grape", List.of("apple", "banana", "grape"))
        );
    }
}
