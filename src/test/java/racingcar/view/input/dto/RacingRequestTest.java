package racingcar.view.input.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.common.exception.dto.ExceptionEnum;
import racingcar.view.input.exception.InputException;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 27.
 */
class RacingRequestTest {



  @BeforeEach
  void setUp(){
  }

  @Test
  void from() {
  }


  @DisplayName("[Success]from : 올바른 사용자 입력")
  @ParameterizedTest
  @MethodSource("validUserInputs")
  void from_shouldReturnCorrectly(String rawCarNames, String roundCount) {
    RacingRequest expected = RacingRequest.from(rawCarNames, roundCount);
    assertEquals(rawCarNames, expected.carNames());
    assertEquals(Integer.parseInt(roundCount), expected.roundCount());
  }

  @DisplayName("[Fail]from : null이 포함된 이름")
  @ParameterizedTest
  @MethodSource("invalidCarNamesWithNull")
  void from_shouldThrowNameWithNull(String rawCarNames, String roundCount) {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class, ()->
            RacingRequest.from(rawCarNames, roundCount));
    assertTrue(exception.getMessage()
        .contains(ExceptionEnum
            .INVALID_CARNAME
            .getMessage()));
  }

  @DisplayName("[Fail]from : 빈 문자열인 이름")
  @ParameterizedTest
  @MethodSource("invalidCarNamesWithEmpty")
  void from_shouldThrowNameWithEmpty(String rawCarNames, String roundCount) {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class, ()->
            RacingRequest.from(rawCarNames, roundCount));
    assertTrue(exception.getMessage()
        .contains(ExceptionEnum
            .INVALID_CARNAME
            .getMessage()));
  }

  @DisplayName("[Fail]from : 스페이스가 포함된 이름")
  @ParameterizedTest
  @MethodSource("invalidCarNamesWithSpace")
  void from_shouldThrowNameWithSpace(String rawCarNames, String roundCount) {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class, ()->
            RacingRequest.from(rawCarNames, roundCount));
    assertTrue(exception.getMessage()
        .contains(ExceptionEnum
            .INVALID_CARNAME
            .getMessage()));
  }

  @DisplayName("[Fail]from : 공백이 포함된 이름")
  @ParameterizedTest
  @MethodSource("invalidCarNamesWithWhiteSpace")
  void from_shouldThrowNameWithWhiteSpace(String rawCarNames, String roundCount) {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class, ()->
            RacingRequest.from(rawCarNames, roundCount));
    assertTrue(exception.getMessage()
        .contains(ExceptionEnum
            .INVALID_WHITESPACE
            .getMessage()));
  }

  @DisplayName("[Fail]from : 유효하지 않은 경주 시도 횟수 입력")
  @ParameterizedTest
  @MethodSource("invalidRoundCounts")
  void from_shouldThrowCorrespondExceptionEnum(String roundCount,
      ExceptionEnum exceptionEnum)
  {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> RacingRequest.from("car1,car2", roundCount));
    assertTrue(exception.getMessage()
        .contains(exceptionEnum.getMessage()));
  }

  public static Stream<Arguments> validUserInputs() {
    return Stream.of(
        Arguments.of("a,b,c", "3"),
        Arguments.of("jane,harry,james", "5")
    );
  }

  private static Stream<Arguments> invalidCarNamesWithNull() {
    return Stream.of(
        Arguments.of(null, "3"),
        Arguments.of(null, "5")
    );
  }

  private static Stream<Arguments> invalidCarNamesWithEmpty() {
    return Stream.of(
        Arguments.of("", "3"),
        Arguments.of("", "4")
    );
  }

  private static Stream<Arguments> invalidCarNamesWithSpace() {
    return Stream.of(
        Arguments.of("  ", "3"),
        Arguments.of("  ", "4")
    );
  }


  private static Stream<Arguments> invalidCarNamesWithWhiteSpace() {
    return Stream.of(
        Arguments.of("a,\tb,vvv,a", "5"),
        Arguments.of("a,\nb,vvv,a", "5"),
        Arguments.of("a,\fb,vvv,a", "5"),
        Arguments.of("a,\rb,vvv,a", "5")
    );
  }

  private static Stream<Arguments> invalidRoundCounts() {
    return Stream.of(
        Arguments.of(null, ExceptionEnum.INVALID_ROUND_COUNT),
        Arguments.of("", ExceptionEnum.INVALID_ROUND_COUNT),
        Arguments.of("   ", ExceptionEnum.INVALID_ROUND_COUNT),
        Arguments.of("3.5", ExceptionEnum.ROUND_COUNT_DECIMAL_NUMBER_NOT_AVAILABLE),
        Arguments.of("0", ExceptionEnum.ROUND_COUNT_NEGATIVE_NUMBER_NOT_AVAILABLE),
        Arguments.of("-1", ExceptionEnum.ROUND_COUNT_NEGATIVE_NUMBER_NOT_AVAILABLE),
        Arguments.of(String.valueOf(2147483648L), ExceptionEnum.ROUND_COUNT_OUT_OF_INTEGER_RANGE),
        Arguments.of("abc", ExceptionEnum.ROUND_COUNT_OUT_OF_INTEGER_RANGE),
        Arguments.of("\t6", ExceptionEnum.INVALID_WHITESPACE),
        Arguments.of("\n6", ExceptionEnum.INVALID_WHITESPACE),
        Arguments.of("\r6", ExceptionEnum.INVALID_WHITESPACE),
        Arguments.of("\f6", ExceptionEnum.INVALID_WHITESPACE)
    );
  }
}