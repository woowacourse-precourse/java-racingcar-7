package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ViewTest {

    @DisplayName("이름 분할 테스트")
    @ParameterizedTest
    @MethodSource("expectedAndResult")
    void inputCarNames(String input, List<String> expected) {


        View view = new View();

        List<String> result = view.inputCarNames(input);

        // 결과 검증
        assertEquals(expected, result);
    }

    static Stream<Arguments> expectedAndResult() {
        return Stream.of(
            Arguments.arguments("woni,pobi", Arrays.asList("woni", "pobi")),
            Arguments.arguments("car1", Arrays.asList("car1")),
            Arguments.arguments("pobi ,woni ", Arrays.asList("pobi","woni"))
        );
    }

}
