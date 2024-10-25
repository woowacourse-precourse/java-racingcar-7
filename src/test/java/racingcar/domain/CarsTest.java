package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

  // ## Happy Case

  @Test
  @DisplayName("중복되지 않은 이름으로 Cars 객체를 생성한다.")
  void 중복되지_않은_이름으로_생성() {
    // Given
    String input = "pobi, jun, car1";

    // When
    Cars cars = new Cars(input);

    // Then
    assertEquals(3, cars.size());
    assertTrue(cars.contains(new Car("pobi")));
    assertTrue(cars.contains(new Car("jun")));
    assertTrue(cars.contains(new Car("car1")));
  }

  @Test
  @DisplayName("공백이 포함된 이름을 trim()하여 Cars 객체를 생성한다.")
  void 공백_포함된_이름_trim_후_Cars_생성() {
    // Given
    String input = " pobi ,  jun , car2 ";

    // When
    Cars cars = new Cars(input);

    // Then
    assertEquals(3, cars.size());
    assertTrue(cars.contains(new Car("pobi")));
    assertTrue(cars.contains(new Car("jun")));
    assertTrue(cars.contains(new Car("car2")));
  }

  @Test
  @DisplayName("숫자와 특수문자가 포함된 이름으로 Cars 객체를 생성한다.")
  void 숫자와_특수문자_포함된_이름으로_Cars_생성() {
    // Given
    String input = "car1!, pobi@";

    // When
    Cars cars = new Cars(input);

    // Then
    assertEquals(2, cars.size());
    assertTrue(cars.contains(new Car("car1!")));
    assertTrue(cars.contains(new Car("pobi@")));
  }

  // ## Bad Case

  @Test
  @DisplayName("중복된 이름이 포함된 경우 예외를 던진다.")
  void 중복된_이름_예외() {
    // Given
    String input = "pobi, pobi, jun";

    // When & Then
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> new Cars(input)
    );
    assertEquals("Error: 중복된 자동차 이름은 허용되지 않습니다.", exception.getMessage());
  }

  @Test
  @DisplayName("자동차 이름이 5자를 초과하면 예외를 던진다.")
  void 이름_길이_초과_예외() {
    // Given
    String input = "pobi, longname";

    // When & Then
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> new Cars(input)
    );
    assertEquals("Error: 자동차 이름은 5자 이하로 입력해야 합니다.", exception.getMessage());
  }

  @Test
  @DisplayName("빈 문자열을 이름으로 사용할 경우 예외를 던진다.")
  void 빈_문자열_예외() {
    // Given
    String input = "pobi, ";

    // When & Then
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> new Cars(input)
    );
    assertEquals("Error: 자동차 이름은 비어있을 수 없습니다.", exception.getMessage());
  }

  @Test
  @DisplayName("공백 문자열을 이름으로 사용할 경우 예외를 던진다.")
  void 공백_문자열_예외() {
    // Given
    String input = "  , pobi";

    // When & Then
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> new Cars(input)
    );
    assertEquals("Error: 자동차 이름은 비어있을 수 없습니다.", exception.getMessage());
  }

  @Test
  @DisplayName("입력값이 null일 경우 예외를 던진다.")
  void null_이름_예외() {
    // Given
    String input = null;

    // When & Then
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> new Cars(input)
    );
    assertEquals("Error: 입력값은 비어있을 수 없습니다.", exception.getMessage());
  }

  @Test
  @DisplayName("숫자만으로 이루어진 이름이 5자를 초과할 경우 예외를 던진다.")
  void 숫자만으로_이루어진_이름_길이_초과_예외() {
    // Given
    String input = "123456, pobi";

    // When & Then
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> new Cars(input)
    );
    assertEquals("Error: 자동차 이름은 5자 이하로 입력해야 합니다.", exception.getMessage());
  }
}
