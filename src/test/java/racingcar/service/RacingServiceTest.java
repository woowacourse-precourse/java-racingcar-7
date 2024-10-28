package racingcar.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.InputParser;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.util.InputRegexConst.LAPS_NUMBER_REGEX;
import static racingcar.util.InputRegexConst.RACERS_NAME_REGEX;

class RacingServiceTest {
    static Stream<Arguments> provideValidUserInput() {
        return Stream.of(
                Arguments.of("a,b,c", 5),
                Arguments.of("abcde,b,c", 5),
                Arguments.of("a,b", 5),
                Arguments.of("a", 3)
        );
    }

    @ParameterizedTest(name = "{index} driverName: {0}, laps: {1} is valid")
    @MethodSource("provideValidUserInput")
    void validNameAndLapsTest(String driverNames, int laps) {
        String racerInputRegex = RACERS_NAME_REGEX.getRegex();
        String lapsNumberRegexRegex = LAPS_NUMBER_REGEX.getRegex();

        assertThat(InputParser.isMatchWithRegex(driverNames, racerInputRegex))
                .isTrue();
        assertThat(InputParser.isMatchWithRegex(String.valueOf(laps), lapsNumberRegexRegex))
                .isTrue();
    }

    static Stream<Arguments> provideInvalidDriverNames() {
        return Stream.of(
                Arguments.of("moreThan5Words"),
                Arguments.of("a,,b"),
                Arguments.of("a, ,b"),
                Arguments.of("a,b,")
        );
    }

    @ParameterizedTest(name = "{index} driverName: {0}")
    @MethodSource("provideInvalidDriverNames")
    void invalidDriverNamesAndLapsTest(String driverNames) {
        String racerInputRegex = RACERS_NAME_REGEX.getRegex();

        assertThat(InputParser.isMatchWithRegex(driverNames, racerInputRegex))
                .isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void lapNumberShouldBePositive(int lapNum) {
        assertThat(InputParser.isMatchWithRegex(String.valueOf(lapNum), LAPS_NUMBER_REGEX.getRegex()))
                .isFalse();
    }
}