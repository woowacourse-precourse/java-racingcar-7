package racingcar.utils;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ParserTest {
    @ParameterizedTest
    @MethodSource("generateParameters")
    void 입력으로부터_자동차_이름_목록_파싱(String input, List<String> expected) {
        Assertions.assertThat(Parser.parseCarNames(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> generateParameters() {
        return Stream.of(
                Arguments.of("name1,name2,name3", List.of("name1", "name2", "name3")),
                Arguments.of("AAA,BBb,Ccc", List.of("AAA", "BBb", "Ccc")),
                Arguments.of(",a1,b2,,", List.of("", "a1", "b2")),
                Arguments.of(",A,A,B", List.of("", "A", "A", "B"))
        );
    }

}