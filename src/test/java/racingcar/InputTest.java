package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import racingcar.common.io.Input;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;

class InputTest {

  @AfterEach
  void closeConsole() {
    Console.close();
  }

  @Test
  void 자동차_이름_정상입력_테스트() {
    String input = "jhs,hsj,jwj\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    Input inputHandler = new Input();
    String[] carNames = inputHandler.getCarNames();

    assertThat(carNames).containsExactly("jhs", "hsj", "jwj");
  }

  @Test
  void 자동차_이름_길이_초과_테스트() {
    String input = "jhs,hsj,JiHyeonSu\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    Input inputHandler = new Input();

    assertThatThrownBy(inputHandler::getCarNames)
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("자동차 이름은 5자 이하여야 합니다.");
  }

  @Test
  void 자동차_이름_빈입력_테스트() {
    String input = "\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    Input inputHandler = new Input();

    assertThatThrownBy(inputHandler::getCarNames)
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("자동차 이름은 빈 문자열이 올 수 없습니다.");
  }

  @Test
  void 이동_시도_횟수_정상입력_테스트() {
    String input = "5\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    Input inputHandler = new Input();
    int attempts = inputHandler.getAttempts();

    assertThat(attempts).isEqualTo(5);
  }

  @Test
  void 이동_시도_횟수_음수입력_테스트() {
    String input = "-1\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    Input inputHandler = new Input();

    assertThatThrownBy(inputHandler::getAttempts)
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("시도 횟수는 1 이상이어야 합니다.");
  }

  @Test
  void 이동_시도_횟수_문자입력_테스트() {
    String input = "abc\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));

    Input inputHandler = new Input();

    assertThatThrownBy(inputHandler::getAttempts)
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("올바른 숫자를 입력해야 합니다.");
  }
}
