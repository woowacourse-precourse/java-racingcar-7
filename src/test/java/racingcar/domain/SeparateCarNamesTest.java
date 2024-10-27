package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SeparateCarNamesTest {

    static Stream<Arguments> provideInValidCommaFormat() {
        return Stream.of(
                Arguments.of(",pobi,woni,jun"),
                Arguments.of("pobi,woni,jun,"),
                Arguments.of("pobi,,woni,jun"),
                Arguments.of(",,"),
                Arguments.of(",")
        );
    }

    @DisplayName("콤마(,)는 문자열와 문자열 사이에 하나만 존재해야 한다.")
    @ParameterizedTest
    @MethodSource("provideInValidCommaFormat")
    void Comma_Should_Be_In_BetWeen_String(String InputCommandLine) {
        assertThrows(IllegalArgumentException.class, () -> {
            RacingCarGame racingCarGame = new RacingCarGame(SeparateCarNames.separateCarNames(InputCommandLine));
        });
    }
}
