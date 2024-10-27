package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.enums.ErrorMessage;

class ApplicationTest extends NsTest {
  private static final int MOVING_FORWARD = 4;
  private static final int STOP = 3;

  @Test
  void 기능_테스트() {
    assertRandomNumberInRangeTest(
        () -> {
          run("pobi,woni", "1");
          assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
        },
        MOVING_FORWARD,
        STOP);
  }

  @Test
  void 예외_테스트() {
    assertSimpleTest(
        () ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class));
  }

  @Test
  void 우승자_여러명_테스트() {
    assertRandomNumberInRangeTest(
        () -> {
          run("pobi,woni,javai", "2");
          assertThat(output())
              .contains("pobi : --", "woni : --", "javai : --", "최종 우승자 : pobi, woni, javai");
        },
        MOVING_FORWARD,
        MOVING_FORWARD,
        MOVING_FORWARD);
  }

  @Test
  void 입력값_유효성_테스트() {
    assertSimpleTest(
        () -> {
          assertThatThrownBy(() -> runException("pobi,,woni", "1"))
              .isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining(ErrorMessage.INVALID_CAR_NAME_EMPTY.getMessage());
        });
  }

  @Test
  void 숫자가_아닌_입력값_예외_테스트() {
    assertSimpleTest(
        () -> {
          assertThatThrownBy(() -> runException("pobi,woni", "one"))
              .isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining(ErrorMessage.INVALID_TURN_NUMBER.getMessage());
        });
  }

  @Test
  void 최대_이름_길이_테스트() {
    assertSimpleTest(
        () -> {
          assertThatThrownBy(() -> runException("pobi,woniknightjava", "2"))
              .isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining(ErrorMessage.INVALID_CAR_NAME_LENGTH.getMessage());
        });
  }

  @Test
  void 여러번_움직이기_테스트() {
    assertRandomNumberInRangeTest(
        () -> {
          run("pobi,woni", "5");
          assertThat(output()).contains("pobi : ----", "woni : ---", "최종 우승자 : pobi");
        },
        MOVING_FORWARD,
        MOVING_FORWARD,
        MOVING_FORWARD,
        STOP,
        MOVING_FORWARD);
  }

  @Override
  public void runMain() {
    Application.main(new String[] {});
  }
}
