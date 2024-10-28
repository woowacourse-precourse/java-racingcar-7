package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.mvc.controller.RacingGameController;
import racingcar.mvc.controller.racingGameManager.CarRacingGameManager;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void setUp() {
        RacingGameController racingGameController = RacingGameController.getInstance();
        racingGameController.setRacingGameManager(new CarRacingGameManager());
    }

    @Test
    @DisplayName("주어진 정상 로직 테스트")
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("정상 테스트 - 참가자 2명 - 우승자 1명")
    void 기능_테스트1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "4");
                    assertThat(output()).contains("pobi : ----", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("정상 테스트 - 참가자 2명 - 우승자 2명")
    void 기능_테스트2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("정상 테스트 - 참가자 3명 - 우승자 3명 - 모두 FORWARD")
    void 기능_테스트3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,son", "2");
                    assertThat(output()).contains("pobi : --", "woni : --", "son : --", "최종 우승자 : pobi, woni, son");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("정상 테스트 - 참가자 3명 - 우승자 2명")
    void 기능_테스트4() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,son", "2");
                    assertThat(output()).contains("pobi : --", "woni : --", "son : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("정상 테스트 - 참가자 3명 - 우승자 3명 - 모두 STOP")
    void 기능_테스트5() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,son", "2");
                    assertThat(output()).contains("pobi : ", "woni : ", "son : ", "최종 우승자 : pobi, woni, son");
                },
                STOP, STOP, STOP, STOP, STOP, STOP
        );
    }

    @Test
    @DisplayName("주어진 예외 테스트")
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    /* 예외
     -- 이름 관련
     * 아무 것도 입력하지 않았을 때
     * 1명만 입력했을 때 (구분자를 포함하지 않을 때)
     * 이름 길이가 5를 넘어갈 때
     * 이름 중간에 공백이 있을 때
     * 허용된 특수문자 외에 다른 특수문자가 들어갈 때
     * 이름이 중복될 때
     -- 시도 횟수 관련
     * 아무 것도 입력하지 않았을 때
     ---- 숫자가 아닐 때
     * 문자
     ---- 양수가 아닐 때
     * 소수
     * 음수
     * 0
     */
    @Test
    @DisplayName("이름 - 예외 테스트 - 구분자로 파싱했을 때 빈 칸")
    void 이름_예외_테스트_끝에_아무것도_입력하지_않았을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jaja,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력하지 않았습니다.")
        );
    }

    @Test
    @DisplayName("이름 - 예외 테스트 - 아무것도 입력하지 않았을 때")
    void 이름_예외_테스트_아무것도_입력하지_않았을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("이름 - 예외 테스트 - 한 명만 입력했을 때")
    void 이름_예외_테스트_한명만_입력했을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("이름 - 예외 테스트 - 이름의 길이가 제한길이를 초과할 때")
    void 이름_예외_테스트_이름길이가_제한된_길이를_초과할_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,sonny,grande", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("이름 - 예외 테스트 - 이름의 중간에 공백이 있을 때")
    void 이름_예외_테스트_이름_중간에_공백이_있을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,so ny,gra", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("이름 -  테스트 - 허용된 특수문자 외 입력")
    void 이름_예외_테스트_허용된_특수문자_외에_다른_특수문자가_들어갈_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,so*ny,gra", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("이름 - 예외 테스트 - 이름 중복")
    void 이름_예외_테스트_이름이_중복될_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("son,pobi,pobi", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도횟수 - 예외 테스트 - 입력하지 않았을 때")
    void 시도횟수_예외_테스트_아무_것도_입력하지_않았을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도횟수 - 예외 테스트 - 문자 입력")
    void 시도횟수_예외_테스트_문자일_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "ㅁ"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도횟수 - 예외 테스트 - 소수 입력")
    void 시도횟수_예외_테스트_소수일_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "7.7"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도횟수 - 예외 테스트 - 음수 입력")
    void 시도횟수_예외_테스트_음수일_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도횟수 - 예외 테스트 - 0 입력")
    void 시도횟수_예외_테스트_0일_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도횟수 - 예외 테스트 - int 범위 밖 입력")
    void 시도횟수_예외_테스트_범위밖일_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "2147483648"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
