package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ServiceTest {
    private Service service;

    @BeforeEach
    void setUp() {
        service = new Service();
    }

    @DisplayName("이름을 \",\"로 구분하여 list 로 반환한다.")
    @MethodSource("provideSplitCarNamesTestCases")
    @ParameterizedTest(name = "기대값: \"{0}\", 입력값: \"{1}\"")
    void splitCarNames(ArrayList<String> expected, String carNames) {
        assertEquals(expected, service.splitCarNames(carNames));
    }

    private static Stream<Arguments> provideSplitCarNamesTestCases() {
        return Stream.of(
                Arguments.of(new ArrayList<>(Arrays.asList("pobi", "woni", "jun")), "pobi,woni,jun")
        );
    }

}
