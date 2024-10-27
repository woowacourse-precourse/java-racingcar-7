package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class InputViewTest extends NsTest {

    @Test
    void 자동차_이름_입력_빈값_실패() {
        assertThatThrownBy(() -> run("","1"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("빈 값을 입력하셨습니다");
    }

    @Test
    void 숫자_입력_빈값_실패() {
        assertThatThrownBy(() -> run("test,test"," "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 값을 입력하셨습니다");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}