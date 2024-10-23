package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {


    @Test
    void is_vaild_input() {
        // 빈 문자열의 경우 예외 처리
        assertThatThrownBy(() -> Application.isValidInput("")).isInstanceOf(IllegalArgumentException.class);
        // 공백 문자열의 경우 예외 처리
        assertThatThrownBy(() -> Application.isValidInput(" ")).isInstanceOf(IllegalArgumentException.class);
        // (,) 쉼표 이외 구분자의 경우 예외 처리
        assertThatThrownBy(() -> Application.isValidInput("pobi, nabi; helo")).isInstanceOf(IllegalArgumentException.class);
        // 이름이 5자 초과인 경우 예외 처리
        assertThatThrownBy(() -> Application.isValidInput("pobi, nabi, javaji")).isInstanceOf(IllegalArgumentException.class);

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
