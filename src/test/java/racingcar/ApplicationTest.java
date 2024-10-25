package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.error.ErrorMessage;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

  private static final int MOVING_FORWARD = 4;
  private static final int STOP = 3;

  @Test
  @DisplayName("자동차_빈문자열")
  void emptyCarString() {
    assertSimpleTest(() -> {

      assertSimpleTest(() ->
          assertThatThrownBy(() -> runException("\n"))
              .isInstanceOf(IllegalArgumentException.class)
              .hasMessage(ErrorMessage.EMPTY_CAR_STRING.getMessage())

      );

      assertSimpleTest(() ->
          assertThatThrownBy(() -> runException(" "))
              .isInstanceOf(IllegalArgumentException.class)

      );

    });
  }

  @Test
  @DisplayName("자동차_구분자없는문자열")
  void noDelimiterCarString() {

    assertSimpleTest(() ->
        assertThatThrownBy(() -> runException("kim|dong|he"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.NO_DELIMITER_CAR_STRING.getMessage())

    );

  }

  @Test
  @DisplayName("유효하지 않은 횟수")
  void NoValidateNums() {

    assertSimpleTest(() -> {

      //숫자가 아닌 문자열
      assertSimpleTest(() ->
          assertThatThrownBy(() -> runException("kim,dong", "e"))
              .isInstanceOf(IllegalArgumentException.class)
              .hasMessage(ErrorMessage.NO_NUMBER_COUNT_STRING.getMessage())
      );

      //정수가 아님
      assertSimpleTest(() ->
          assertThatThrownBy(() -> runException("kim,dong", "1.24"))
              .isInstanceOf(IllegalArgumentException.class)
              .hasMessage(ErrorMessage.NO_NUMBER_COUNT_STRING.getMessage())
      );

      //0임
      assertSimpleTest(() ->
          assertThatThrownBy(() -> runException("kim,dong", "0"))
              .isInstanceOf(IllegalArgumentException.class)
              .hasMessage(ErrorMessage.NO_NUMBER_COUNT_STRING.getMessage())
      );

      //음수임
      assertSimpleTest(() ->
          assertThatThrownBy(() -> runException("kim,dong", "-2"))
              .isInstanceOf(IllegalArgumentException.class)
              .hasMessage(ErrorMessage.NO_NUMBER_COUNT_STRING.getMessage())
      );

    });

  }





  @Override
  public void runMain() {
    Application.main(new String[]{});
  }
}
