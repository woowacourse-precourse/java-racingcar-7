package racingcar.racing.util;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.racing.dto.request.RacingRequestDTO;

class RacingRequestValidatorTest {

    @ParameterizedTest
    @MethodSource("invalidInputSource")
    void 파싱_예외_발생_검증(List<String> carNames, int round) {
        // given
        RacingRequestDTO racingRequestDTO = new RacingRequestDTO(carNames, round);

        // when, then
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> RacingRequestValidator.validateRacingRequest(racingRequestDTO)
        );
    }

    private static Stream<Arguments> invalidInputSource() {
        return Stream.of(
                Arguments.of(List.of("pobiIsLong", "woni", "java"), 5),
                Arguments.of(List.of(""), 4),
                Arguments.of(List.of("", "qwer"), 4),
                Arguments.of(List.of("java", "woni", "java"), 5)
        );
    }
}