package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

  private static final int MOVING_FORWARD = 4;
  private static final int STOP = 3;

  @Test
  void 기능_테스트() {
    assertRandomNumberInRangeTest(() -> {
      run("pobi,woni", "1");
      assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
    }, MOVING_FORWARD, STOP);
  }

  @Test
  void 예외_테스트() {
    assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaji", "1")).isInstanceOf(
        IllegalArgumentException.class));
  }

  @Test
  @DisplayName("자동차 이름에 공백이 포함된 경우 예외 발생")
  void 자동차_이름에_공백이_포함된_경우_예외_발생() {
    assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi, ,woni", "1")).isInstanceOf(
        IllegalArgumentException.class));
  }

  @Test
  @DisplayName("자동차 이름이 5자를 초과하는 경우 예외 발생")
  void 자동차_이름이_5자를_초과하는_경우_예외_발생() {
    assertSimpleTest(
        () -> assertThatThrownBy(() -> runException("pobi,woniislong", "1")).isInstanceOf(
            IllegalArgumentException.class));
  }

  @Test
  @DisplayName("자동차 이름에 빈 문자열이 있는 경우 예외 발생")
  void 자동차_이름에_빈_문자열이_있는_경우_예외_발생() {
    assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,,woni", "1")).isInstanceOf(
        IllegalArgumentException.class));
  }

  @Test
  @DisplayName("자동차 이름이 중복되는 경우 예외 발생")
  void 자동차_이름이_중복되는_경우_예외_발생() {
    assertSimpleTest(
        () -> assertThatThrownBy(() -> runException("pobi,pobi,woni", "1")).isInstanceOf(
            IllegalArgumentException.class));
  }

  @Test
  @DisplayName("자동차 이름에 대소문자만 다른 중복 이름이 있는 경우 예외 발생")
  void 자동차_이름에_대소문자만_다른_중복_이름이_있는_경우_예외_발생() {
    assertSimpleTest(
        () -> assertThatThrownBy(() -> runException("pobi,POBI,woni", "1")).isInstanceOf(
            IllegalArgumentException.class));
  }

  @Test
  @DisplayName("자동차 이름에 여러 개의 쉼표가 연속으로 있는 경우 예외 발생")
  void 자동차_이름에_여러_개의_쉼표가_연속으로_있는_경우_예외_발생() {
    assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,,woni", "1")).isInstanceOf(
        IllegalArgumentException.class));
  }

  @Test
  @DisplayName("자동차 이름에 공백과 탭이 섞여 있는 경우 예외 발생")
  void 자동차_이름에_공백과_탭이_섞여_있는_경우_예외_발생() {
    assertSimpleTest(
        () -> assertThatThrownBy(() -> runException("pobi, \t ,woni", "1")).isInstanceOf(
            IllegalArgumentException.class));
  }

  @Test
  @DisplayName("자동차 이름에 공백만 있는 경우 예외 발생")
  void 자동차_이름에_공백만_있는_경우_예외_발생() {
    assertSimpleTest(() -> assertThatThrownBy(() -> runException("   ", "1")).isInstanceOf(
        IllegalArgumentException.class));
  }

  @Test
  @DisplayName("자동차 이름에 줄바꿈 문자가 포함된 경우 예외 발생")
  void 자동차_이름에_줄바꿈_문자가_포함된_경우_예외_발생() {
    assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,\nwoni", "1")).isInstanceOf(
        IllegalArgumentException.class));
  }

  @Test
  @DisplayName("자동차 이름에 모든 이름이 동일한 경우 예외 발생")
  void 자동차_이름에_모든_이름이_동일한_경우_예외_발생() {
    assertSimpleTest(
        () -> assertThatThrownBy(() -> runException("pobi,pobi,pobi", "1")).isInstanceOf(
            IllegalArgumentException.class));
  }

  @Test
  @DisplayName("게임 횟수 입력이 음수인 경우 예외 발생")
  void 게임_횟수_입력이_음수인_경우_예외_발생() {
    assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni", "-1")).isInstanceOf(
        IllegalArgumentException.class));
  }

  @Test
  @DisplayName("게임 횟수 입력이 0인 경우 예외 발생")
  void 게임_횟수_입력이_0인_경우_예외_발생() {
    assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni", "0")).isInstanceOf(
        IllegalArgumentException.class));
  }

  @Test
  @DisplayName("게임 횟수 입력이 int 범위를 넘는 경우 예외 발생")
  void 게임_횟수_입력이_int_범위를_넘는_경우_예외_발생() {
    assertSimpleTest(
        () -> assertThatThrownBy(() -> runException("pobi,woni", "2147483648")).isInstanceOf(
            IllegalArgumentException.class));
  }

  @Test
  @DisplayName("게임 횟수 입력이 null인 경우 예외 발생")
  void 게임_횟수_입력이_null인_경우_예외_발생() {
    assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni", null)).isInstanceOf(
        IllegalArgumentException.class));
  }

  @Test
  @DisplayName("게임 횟수 입력에 소수점이 포함된 경우 예외 발생")
  void 게임_횟수_입력에_소수점이_포함된_경우_예외_발생() {
    assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni", "1.5")).isInstanceOf(
        IllegalArgumentException.class));
  }

  @Test
  @DisplayName("게임 횟수 입력에 음수와 문자가 섞여 있는 경우 예외 발생")
  void 게임_횟수_입력에_음수와_문자가_섞여_있는_경우_예외_발생() {
    assertSimpleTest(
        () -> assertThatThrownBy(() -> runException("pobi,woni", "-1abc")).isInstanceOf(
            IllegalArgumentException.class));
  }

  @Test
  @DisplayName("게임 횟수 입력이 공백 문자열인 경우 예외 발생")
  void 게임_횟수_입력이_공백_문자열인_경우_예외_발생() {
    assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni", " ")).isInstanceOf(
        IllegalArgumentException.class));
  }

  @Test
  @DisplayName("게임 횟수에 특수 문자가 포함된 경우 예외 발생")
  void 게임_횟수에_특수_문자가_포함된_경우_예외_발생() {
    assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni", "#$%")).isInstanceOf(
        IllegalArgumentException.class));
  }

  @Test
  @DisplayName("게임 횟수 입력에 Long.MAX_VALUE를 입력한 경우 예외 발생")
  void 게임_횟수_입력에_Long_MAX_VALUE를_입력한_경우_예외_발생() {
    assertSimpleTest(() -> assertThatThrownBy(
        () -> runException("pobi,woni", String.valueOf(Long.MAX_VALUE))).isInstanceOf(
        IllegalArgumentException.class));
  }

  @Test
  @DisplayName("게임 횟수 입력에 1보다 작은 소수를 입력한 경우 예외 발생")
  void 게임_횟수_입력에_1보다_작은_소수를_입력한_경우_예외_발생() {
    assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,woni", "0.5")).isInstanceOf(
        IllegalArgumentException.class));
  }

  // 정상 상황 테스트 케이스
  @Test
  @DisplayName("자동차 이름에 숫자가 포함된 경우 허용")
  void 자동차_이름에_숫자가_포함된_경우_허용() {
    assertRandomNumberInRangeTest(() -> {
      run("car1,car2", "1");
      assertThat(output()).contains("car1 : -", "car2 : -", "최종 우승자 : car1, car2");
    }, MOVING_FORWARD, MOVING_FORWARD);
  }

  @Test
  @DisplayName("자동차 이름에 최대 길이의 이름이 포함된 경우 정상 진행")
  void 자동차_이름에_최대_길이의_이름이_포함된_경우_정상_진행() {
    assertRandomNumberInRangeTest(() -> {
      run("pobi,woni,abcde", "1");
      assertThat(output()).contains("pobi : -", "woni : ", "abcde : -", "최종 우승자 : pobi, abcde");
    }, MOVING_FORWARD, STOP, MOVING_FORWARD);
  }

  @Test
  @DisplayName("자동차 이름에 앞뒤로 공백이 있는 경우 정상 처리")
  void 자동차_이름에_앞뒤로_공백이_있는_경우_정상_처리() {
    assertRandomNumberInRangeTest(() -> {
      run(" pobi , woni ", "1");
      assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
    }, MOVING_FORWARD, MOVING_FORWARD);
  }

  @Test
  @DisplayName("게임 횟수 입력에 앞뒤로 공백이 있는 경우 정상 처리")
  void 게임_횟수_입력에_앞뒤로_공백이_있는_경우_정상_처리() {
    assertRandomNumberInRangeTest(() -> {
      run("pobi,woni", " 1 ");
      assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
    }, MOVING_FORWARD, MOVING_FORWARD);
  }

  @Test
  @DisplayName("자동차 이름에 한글이 포함된 경우 정상 처리")
  void 자동차_이름에_한글이_포함된_경우_정상_처리() {
    assertRandomNumberInRangeTest(() -> {
      run("포비,워니", "1");
      assertThat(output()).contains("포비 : -", "워니 : ", "최종 우승자 : 포비");
    }, MOVING_FORWARD, STOP);
  }

  @Test
  @DisplayName("자동차 이름에 길이가 1자인 이름이 있는 경우 정상 처리")
  void 자동차_이름에_길이가_1자인_이름이_있는_경우_정상_처리() {
    assertRandomNumberInRangeTest(() -> {
      run("pobi,w,a", "1");
      assertThat(output()).contains("pobi : -", "w : ", "a : -", "최종 우승자 : pobi, a");
    }, MOVING_FORWARD, STOP, MOVING_FORWARD);
  }

  @Test
  @DisplayName("자동차 이름에 숫자만 있는 경우 정상 처리")
  void 자동차_이름에_숫자만_있는_경우_정상_처리() {
    assertRandomNumberInRangeTest(() -> {
      run("123,456", "1");
      assertThat(output()).contains("123 : -", "456 : ", "최종 우승자 : 123");
    }, MOVING_FORWARD, STOP);
  }

  @Test
  @DisplayName("게임 횟수가 매우 큰 경우 정상적으로 게임 진행")
  void 게임_횟수가_매우_큰_경우_정상적으로_게임_진행() {
    assertRandomNumberInRangeTest(() -> {
      run("pobi,woni", "100");
      assertThat(output()).contains("최종 우승자");
    }, 100, 100);
  }

  @Override
  public void runMain() {
    Application.main(new String[]{});
  }
}
