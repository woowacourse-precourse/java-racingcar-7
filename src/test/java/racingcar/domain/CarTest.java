package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

  // ## Happy Case

  @Test
  @DisplayName("정상적인 이름으로 Car 객체를 생성한다.")
  void 정상적인_이름으로_Car_생성() {
    // Given
    String name = "pobi";

    // When
    CarName carName = new CarName(name);

    // Then
    assertNotNull(carName);
  }

  @Test
  @DisplayName("공백이 포함된 이름을 trim()한 후 Car 객체를 생성한다.")
  void 공백_포함된_이름_trim_후_생성() {
    // Given
    String name = " pobi ";

    // When
    CarName carName = new CarName(name.trim());

    // Then
    String expectedCarName = "pobi";
    assertEquals(expectedCarName, carName.value());
  }

  @Test
  @DisplayName("숫자와 특수문자가 포함된 이름으로 Car 객체를 생성한다.")
  void 숫자와_특수문자_포함된_이름_생성() {
    // Given
    String name = "car1!";

    // When
    CarName carName = new CarName(name);

    // Then
    String expectedCarName = "car1!";
    assertEquals(expectedCarName, carName.value());
  }

  @Test
  @DisplayName("이름이 정확히 5자인 경우 Car 객체를 생성한다.")
  void 이름_길이_정확히_5자_생성() {
    // Given
    String name = "abcde";

    // When
    CarName carName = new CarName(name);

    // Then
    String expectedCarName = "abcde";
    assertEquals(expectedCarName, carName.value());
  }

  // ## Bad Case

  @Test
  @DisplayName("자동차 이름이 5자를 초과하면 예외를 던진다.")
  void 이름_길이_초과_예외() {
    // Given
    String name = "longname";

    // When & Then
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> new CarName(name)
    );
    assertEquals("Error: 자동차 이름은 5자 이하로 입력해야 합니다.", exception.getMessage());
  }

  @Test
  @DisplayName("빈 문자열을 이름으로 사용할 경우 예외를 던진다.")
  void 빈_문자열_예외() {
    // Given
    String name = "";

    // When & Then
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> new CarName(name)
    );
    assertEquals("Error: 자동차 이름은 비어있을 수 없습니다.", exception.getMessage());
  }

  @Test
  @DisplayName("공백 문자열을 이름으로 사용할 경우 예외를 던진다.")
  void 공백_문자열_예외() {
    // Given
    String name = "   ";

    // When & Then
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> new CarName(name.trim())
    );
    assertEquals("Error: 자동차 이름은 비어있을 수 없습니다.", exception.getMessage());
  }

  @Test
  @DisplayName("null을 이름으로 사용할 경우 예외를 던진다.")
  void null_이름_예외() {
    // Given
    String name = null;

    // When & Then
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> new CarName(name)
    );
    assertEquals("Error: 자동차 이름은 비어있을 수 없습니다.", exception.getMessage());
  }

  @Test
  @DisplayName("숫자만으로 이루어진 이름이 5자를 초과할 경우 예외를 던진다.")
  void 숫자만으로_이루어진_이름_길이_초과_예외() {
    // Given
    String name = "123456";

    // When & Then
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> new CarName(name)
    );
    assertEquals("Error: 자동차 이름은 5자 이하로 입력해야 합니다.", exception.getMessage());
  }
}
