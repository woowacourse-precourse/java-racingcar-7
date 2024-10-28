package racingcar.io;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class InputViewTest extends NsTest {

    @Test
    void 자동차_이름_입력_빈값_실패() {
        assertThatThrownBy(() -> run("","1"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("빈 값을 입력하셨습니다");
    }

    @Test
    void 이동횟수_입력_빈값_실패() {
        assertThatThrownBy(() -> run("test,test1"," "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 값을 입력하셨습니다");
    }

    @Test
    void 이동횟수_입력_숫자가_아닌_값_실패() {
        assertThatThrownBy(() -> run("test,test1","test"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("문자나 정수 범위를 넘어가는 숫자는 입력하실 수 없습니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}