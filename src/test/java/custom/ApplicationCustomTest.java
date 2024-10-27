package custom;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class ApplicationCustomTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    // 자동차 이름 입력 예외 테스트
    @Test
    void 자동차이름입력_입력이빈문자열일때_테스트() {
        assertThatThrownBy(() -> runException("", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 빈 문자열 일 수 없습니다");
    }

    @Test
    void 자동차이름입력_입력이공백으로구성되어있을때_테스트() {
        assertThatThrownBy(() -> runException("   ", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 공백으로만 구성될 수 없습니다");
    }

    @Test
    void 자동차이름입력_입력이공백과쉼표로구성되어있을때_테스트() {
        assertThatThrownBy(() -> runException(" , ,  ,,  ,,,", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력이 이루어지지 않았습니다");
    }

    @Test
    void 자동차대수판별_테스트() {
        assertThatThrownBy(() -> runException("pobi", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차가 2대 미만 입력되었습니다");
    }

    @Test
    void 자동차이름입력_길이검증_테스트() {
        assertThatThrownBy(() -> runException("pobi,longCarName", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 중 5자를 초과하는 이름이 있습니다");
    }

    @Test
    void 자동차이름입력_중복여부검증_테스트() {
        assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 중 중복된 이름이 있습니다");
    }

    @Test
    void 자동차이름입력_공백여부검증_테스트() {
        assertThatThrownBy(() -> runException("pobi,ju n", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 중 공백이 포함된 이름이 있습니다");
    }

    @Test
    void 자동차이름입력_구성문자검증_테스트() {
        assertThatThrownBy(() -> runException("pobi,123", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차량 이름은 알파벳이나 한글로 작성되어야 합니다.");
    }

    // 실행 횟수 입력 예외 테스트
    @Test
    void 실행횟수입력_입력이공백으로구성되어있을때_테스트() {
        assertThatThrownBy(() -> runException("pobi,woni", "      "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 공백으로만 구성될 수 없습니다");
    }

    @Test
    void 실행횟수입력_숫자가아닐때_테스트() {
        assertThatThrownBy(() -> runException("pobi,jun", "abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 횟수는 숫자를 입력해야합니다");
    }

    @Test
    void 실행횟수입력_int타입의범위를초과할때_테스트() {
        assertThatThrownBy(() -> runException("pobi,jun", "2147483648")) // Integer.MAX_VALUE + 1
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 횟수가 int 타입의 범위를 초과합니다");
    }

    @Test
    void 실행횟수입력_1회미만일때_테스트() {
        assertThatThrownBy(() -> runException("pobi,jun", "0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 횟수는 1회 이상이여야 합니다");
    }

    // 정상 테스트

    @Test
    void 자동차이름입력_연속쉼표존재_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,,,,,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 자동차이름입력_앞뒤단일쉼표존재_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(",pobi, woni,", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 자동차이름입력_앞뒤연속쉼표존재_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(",,,pobi, woni,,,", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 자동차이름입력_연속공백존재_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi   ,  woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 자동차이름입력_앞뒤연속공백존재_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("   pobi, woni   ", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 자동차이름입력_쉼표기준으로나누어진공백이2개이상있는경우_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,    ,    ,  ", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}