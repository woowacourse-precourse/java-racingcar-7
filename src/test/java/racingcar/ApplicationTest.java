package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.mvc.controller.RacingGameController;
import racingcar.mvc.controller.racingGameManager.CarRacingGameManager;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 5;
    private static final int STOP = 3;

    @BeforeEach
    void setUp() {
        RacingGameController racingGameController = RacingGameController.getInstance();
        racingGameController.setRacingGameManager(new CarRacingGameManager());
    }

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "4");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
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
    void 이름_예외_테스트_끝에_아무것도_입력하지_않았을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jaja,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력하지 않았습니다.")
        );
    }

    @Test
    void 이름_예외_테스트_아무것도_입력하지_않았을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_예외_테스트_한명만_입력했을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_예외_테스트_이름길이가_제한된_길이를_초과할_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,sonny,grande", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_예외_테스트_이름_중간에_공백이_있을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,so ny,gra", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_예외_테스트_허용된_특수문자_외에_다른_특수문자가_들어갈_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,so*ny,gra", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_예외_테스트_이름이_중복될_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("son,pobi,pobi", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_예외_테스트_아무_것도_입력하지_않았을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_예외_테스트_문자일_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "ㅁ"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_예외_테스트_소수일_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "7.7"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_예외_테스트_음수일_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_예외_테스트_0일_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
