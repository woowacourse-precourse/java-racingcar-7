package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameCountTest {

  // ## Happy Case

  @Test
  @DisplayName("정상적인 1자리 숫자 입력")
  void 정상적인_1자리_숫자_입력() {
    GameCount gameCount = new GameCount("3");
    assertEquals(3, gameCount.getCount());
  }

  @Test
  @DisplayName("정상적인 큰 숫자 입력 (int 범위 내)")
  void 정상적인_큰_숫자_입력() {
    GameCount gameCount = new GameCount("2147483647");
    assertEquals(2147483647, gameCount.getCount());
  }

  // ## Bad Case

  @Test
  @DisplayName("null 입력 시 예외 발생")
  void null_입력_예외() {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> new GameCount(null)
    );
    assertEquals("Error: 입력값이 null일 수 없습니다.", exception.getMessage());
  }

  @Test
  @DisplayName("문자 입력 시 예외 발생")
  void 문자_입력_예외() {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> new GameCount("a")
    );
    assertEquals("Error: 시도 횟수는 1 이상 2,147,483,647 이하의 정수여야 합니다.", exception.getMessage());
  }

  @Test
  @DisplayName("음수 입력 시 예외 발생")
  void 음수_입력_예외() {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> new GameCount("-1")
    );
    assertEquals("Error: 시도 횟수는 1 이상의 값이어야 합니다.", exception.getMessage());
  }

  @Test
  @DisplayName("int 범위를 초과하는 숫자 입력 시 예외 발생")
  void int_범위_초과_예외() {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> new GameCount("21474836481")
    );
    assertEquals("Error: 시도 횟수는 1 이상 2,147,483,647 이하의 정수여야 합니다.", exception.getMessage());
  }
}
