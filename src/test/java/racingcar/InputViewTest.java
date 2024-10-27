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
    void 이동횟수_입력_빈값_실패() {
        assertThatThrownBy(() -> run("test,test"," "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 값을 입력하셨습니다");
    }

    @Test
    void 이동횟수_입력_숫자가_아닌_값_실패() {
        assertThatThrownBy(() -> run("test,test","test"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해주세요");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}