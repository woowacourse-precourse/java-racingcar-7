package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class WinnerTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    // 정상 출력 되는데 안 됨
    @Test
    @DisplayName("사용자가 경주할 자동차 이름을 작성 안 했을 때")
    void 자동차_이름_미입력() {
        assertSimpleTest(() -> {
            run(" "); // 빈 문자열 입력
            assertThat(output()).contains("자동차 이름은 비어 있을 수 없습니다."); // 출력 메시지 수정
        });
    }

    // 정상 출력 되는데 안 됨
    @Test
    @DisplayName("사용자가 경주할 자동차 이름을 중복 작성 했을 때")
    void 자동차_이름_중복입력() {
        assertSimpleTest(() -> {
            run("pobi,pobi");
            assertThat(output()).contains("자동차 이름은 중복될 수 없습니다 : pobi");
        });
    }

    @Test
    @DisplayName("자동차 이름 구분자가 쉼표가 아닌 다른 문자열이 들어왔을 때")
    void 자동차_이름_구분자_오류() {
        assertSimpleTest(() -> {
            run("pobi;woni", "1");
            assertThat(output()).contains("자동차 이름은 쉼표로 구분해야 합니다."); // 출력 메시지 수정
        });
    }

    @Test
    @DisplayName("자동차 이름 입력에 숫자가 들어왔을 때")
    void 자동차_이름_문자입력_오류() {
        assertSimpleTest(() -> {
            run("pobi,1234", "1");
            assertThat(output()).contains("자동차 이름은 문자여야 합니다."); // 출력 메시지 수정
        });
    }

    @Override
    protected void runMain() {

    }
}

