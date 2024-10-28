package racingcar.strategy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;
import racingcar.common.exception.dto.ExceptionEnum;
import racingcar.container.DependencyInjectionContainer;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 27.
 */
class CarBasicStrategyTest {
  private CarStrategy carBasicStrategy;


  @BeforeEach
  void setUp(){
    carBasicStrategy = new CarBasicStrategy();
  }


  @DisplayName("[Success]splitName : 올바른 입력")
  @ParameterizedTest
  @ValueSource(strings = {
      "car1,car2,car3",
      "1a,2b,3b",
      "1a,2b,3b",
  })
  void splitNames_shouldSplitCorrectly(String input) {
    List<String> expected = Arrays.stream
        (input.split(","))
        .toList();
    List<String> result = carBasicStrategy.splitNames(input);
    assertEquals(expected, result);
  }

  @DisplayName("[Success]validateNames : 올바른 입력")
  @ParameterizedTest
  @MethodSource("validCarNameLists")
  void validateNames_shouldAccept(List<String> carNames) {
    assertDoesNotThrow(() ->
        carBasicStrategy
            .validateNames(carNames));
  }

  @DisplayName("[Fail]validateNames : 5자 보다 긴 자동차 이름 예외 처리")
  @ParameterizedTest
  @ValueSource(strings = {
      "longName",
      "123456",
      "        ",
  })
  void validateNames_shorThrowForLongName(String longName) {
    List<String> names = Arrays.asList("car1", longName);
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class, ()->
            carBasicStrategy.validateNames(names));
    assertTrue(exception.getMessage()
        .contains(ExceptionEnum
            .CAR_NAME_LONGGER_THAN_FIVE
            .getMessage()));
  }

  @DisplayName("[Fail]validateNames : 중복된 이름 예외 처리")
  @ParameterizedTest
  @MethodSource("invalidDuplicatedCarNameLists")
  void validateNames_shorThrowForDuplicatedNames(List<String> duplicatedNames) {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class, ()->
            carBasicStrategy.validateNames(duplicatedNames));
    assertTrue(exception.getMessage()
        .contains(ExceptionEnum
            .DUPLICATE_CAR_NAME
            .getMessage()));
  }

  private static Stream<List<String>> validCarNameLists() {
    return Stream.of(
        List.of("car1", "car2", "car3"),
        List.of("1a", "2b", "3b"),
        List.of("LEO", "leO", "Jiffy")
    );
  }

  private static Stream<List<String>> invalidDuplicatedCarNameLists() {
    return Stream.of(
        List.of("car1", "car1", "car2"),
        List.of("1a", "3b", "3b"),
        List.of("a", "a", "b")
    );
  }
}