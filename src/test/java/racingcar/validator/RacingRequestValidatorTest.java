package racingcar.validator;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.request.RacingRequestDTO;

class RacingRequestValidatorTest {

    private static Stream<Arguments> provideValidInputs() {
        return Stream.of(
                Arguments.of(Arrays.asList("pobi", "woni", "jun"), 1),
                Arguments.of(Arrays.asList("해광", "우테코", "떡볶이최고"), 5),
                Arguments.of(Collections.singletonList("혼자"), 10)
        );
    }

    @ParameterizedTest(name = "차 이름: {0}, 이동 횟수: {1}")
    @MethodSource("provideValidInputs")
    @DisplayName("모든 입력이 유효하면 예외를 던지지 않는다")
    void validate_withValidInputs(List<String> carNames, Integer moveCount) {
        RacingRequestDTO racingRequestDTO = RacingRequestDTO.of(carNames, moveCount);

        assertThatCode(() -> RacingRequestValidator.validate(racingRequestDTO))
                .doesNotThrowAnyException();
    }


    private static Stream<Arguments> provideCarNamesWithBlank() {
        return Stream.of(
                Arguments.of(Arrays.asList("pobi", "", "jun")),
                Arguments.of(Arrays.asList("pobi", "   ", "jun")),
                Arguments.of(Arrays.asList("", "woni", "jun"))
        );
    }

    @ParameterizedTest(name = "차 이름 리스트: {0}")
    @MethodSource("provideCarNamesWithBlank")
    @DisplayName("자동차 이름이 빈 문자열일 때 예외를 던진다")
    void validate_withBlankCarNames(List<String> carNames) {
        RacingRequestDTO racingRequestDTO = RacingRequestDTO.of(carNames, 5);

        assertThatThrownBy(() -> RacingRequestValidator.validate(racingRequestDTO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 비어있습니다.");
    }


    private static Stream<Arguments> provideCarNamesTooLong() {
        return Stream.of(
                Arguments.of(Arrays.asList("pobi", "우아한테크코스라는매우긴이름", "jun")),
                Arguments.of(Arrays.asList("변해광이라는긴이름", "woni", "jun")),
                Arguments.of(Arrays.asList("벼언해애과앙", "ghijk", "lmnop"))
        );
    }

    @ParameterizedTest(name = "차 이름 리스트: {0}")
    @MethodSource("provideCarNamesTooLong")
    @DisplayName("자동차 이름이 5자를 초과할 때 예외를 던진다")
    void validate_withTooLongCarNames(List<String> carNames) {
        RacingRequestDTO racingRequestDTO = RacingRequestDTO.of(carNames, 5);

        assertThatThrownBy(() -> RacingRequestValidator.validate(racingRequestDTO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 5자 초과 되었습니다.");
    }


    @ParameterizedTest(name = "이동 횟수: {0}")
    @ValueSource(ints = {0, -1, -10})
    @DisplayName("이동 횟수가 1 미만일 때 예외를 던진다")
    void validate_withInvalidMoveCounts(Integer moveCount) {
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        RacingRequestDTO racingRequestDTO = RacingRequestDTO.of(carNames, moveCount);

        assertThatThrownBy(() -> RacingRequestValidator.validate(racingRequestDTO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 횟수는 1 이상이어야 합니다.");
    }


    private static Stream<Arguments> provideMultipleInvalidInputs() {
        return Stream.of(
                Arguments.of(Arrays.asList("pobi", "", "jun"), 0),
                Arguments.of(Arrays.asList("pobi", "   ", "jun"), -1),
                Arguments.of(Arrays.asList("", "woniis", "jun"), -10)
        );
    }

    @ParameterizedTest(name = "차 이름 리스트: {0}, 이동 횟수: {1}")
    @MethodSource("provideMultipleInvalidInputs")
    @DisplayName("자동차 이름이 비어있고 이동 횟수가 유효하지 않을 때, 먼저 빈 이름 예외를 던진다")
    void validate_withMultipleInvalidInputs(List<String> carNames, Integer moveCount) {
        RacingRequestDTO racingRequestDTO = RacingRequestDTO.of(carNames, moveCount);

        assertThatThrownBy(() -> RacingRequestValidator.validate(racingRequestDTO))
                .isInstanceOf(IllegalArgumentException.class);
    }
}