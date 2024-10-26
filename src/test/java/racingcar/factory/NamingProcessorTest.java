package racingcar.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NamingProcessorTest {

    private NamingProcessor namingProcessor;

    @BeforeEach
    public void setUp() {
        this.namingProcessor = new NamingProcessor();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("NULL 또는 빈 문자열을 입력하면 예외를 던진다.")
    public void throwExceptionWhenInputNullOrEmpty(String input) {
        assertThatThrownBy(() -> namingProcessor.separateName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("문자열을 넘기면 ,로 구분하여 앞 뒤 공백이 없는 문자열 리스트를 반환한다.")
    @MethodSource("inputAndResultListProvider")
    public void separateNamesWithTrimByComma(String input, List<String> expectedResult) {
        List<String> actualResult = namingProcessor.separateName(input);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> inputAndResultListProvider() {
        return Stream.of(
                Arguments.of("onlyOne", List.of("onlyOne")),
                Arguments.of("one, two", List.of("one", "two")),
                Arguments.of(" one  , t wo  ", List.of("one", "t wo"))
        );
    }

    @Test
    @DisplayName("중복되는 이름이 있으면 예외를 던진다.")
    public void throwExceptionWhenHasDuplicatedName() {
        List<String> names = List.of("name", "name", "another");
        assertThatThrownBy(() -> namingProcessor.checkDuplication(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복되는 이름이 없으면 예외를 던지지 않는다.")
    public void doNotThrowExceptionWhenHasNoDuplicatedName() {
        List<String> names = List.of("one", "two", "three");
        Assertions.assertDoesNotThrow(() -> namingProcessor.checkDuplication(names));
    }

}
