package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameParserTest {

    @DisplayName("문자열에서 자동차 이름을 추출합니다")
    @ParameterizedTest
    @MethodSource("provideInputAndExpectedList")
    void 자동차_이름_추출(String input, List<String> expectedList){
         List<String> carNames = CarNameParser.parseCarName(input);
         Assertions.assertThat(carNames).containsExactlyElementsOf(expectedList);
    }

    static Stream<Arguments> provideInputAndExpectedList() {
        return Stream.of(
                Arguments.of("one,two,three", Arrays.asList("one", "two", "three")),
                Arguments.of("ian, delta, tom", Arrays.asList("ian", "delta", "tom")),
                Arguments.of("dave,kevin, scar", Arrays.asList("dave", "kevin", "scar"))
        );
    }
}
