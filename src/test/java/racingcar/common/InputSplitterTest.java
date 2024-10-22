package racingcar.common;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputSplitterTest {

    @ParameterizedTest(name = "입력값: {0}, 기대값: {1}")
    @MethodSource(value = "provideInput")
    void 입력값_분할_기능_테스트(final String input, final String[] expected, final int expectedSize) {
        // when
        String[] numbers = InputSplitter.split(input);

        // then
        assertThat(numbers).hasSize(expectedSize);
        assertThat(numbers).containsExactly(expected);

        System.out.println(Arrays.toString(numbers));
    }

    @Test
    void 분할된_입력값_연결_기능_테스트() {
        // given
        String[] elements = {"1", "2", "3"};

        // when
        String result = InputSplitter.join(elements);

        // then
        assertThat(result).isEqualTo("1, 2, 3");
    }

    static Stream<Arguments> provideInput() {
        return Stream.of(
                Arguments.of("1", new String[]{"1"}, 1),
                Arguments.of("1,2", new String[]{"1", "2"}, 2),
                Arguments.of("1,2,3", new String[]{"1", "2", "3"}, 3),
                Arguments.of("1,2 3,4", new String[]{"1", "2 3", "4"}, 3),
                Arguments.of("1,,3", new String[]{"1", "", "3"}, 3)
        );
    }
}