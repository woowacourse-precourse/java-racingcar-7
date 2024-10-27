package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.InputValidator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("자동차 이름의 길이가 5 미만이어야 한다.")
    void 자동차_이름_길이_검사() {
        String[] carNames = {"Car1","racingCar1"};
        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputValidator.lenValidate(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차의 이름 길이가 5이상입니다.")
        );
    }

    @Test
    @DisplayName("중복이 되는 이름의 자동차가 있으면 안된다.")
    void 자동차_중복_검사() {
        String[] carNames = {"Car1", "Car1"};
        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputValidator.lenValidate(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름이 중복되었습니다.")
        );
    }

    @Test
    @DisplayName("입력 값이 빈값이나, NULL이 아니어야 한다.")
    void 빈_입력_값_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputValidator.nullValidate(" "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력이 비어있거나 null입니다.")
        );
    }

    @Test
    @DisplayName("시도 횟수가 음수이면 안된다.")
    void 시도_횟수_양수_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputValidator.attemptsValidate(-1))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("시도 횟수는 양수를 입력해야 합니다.")
        );
    }

    @Test
    void 개인_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,rita,uzi", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "rita : ", "uzi : -", "최종 우승자 : uzi");
                },
                STOP, STOP, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 공동_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,rita,uzi", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "rita : -", "uzi : -", "최종 우승자 : pobi, woni, rita, uzi");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
