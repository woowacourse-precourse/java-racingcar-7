package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MyApplicationTest extends NsTest {

    @Test
    void 시도_횟수_입력_예외_테스트() {
        assertThatThrownBy(() -> {
            run("pobi,woni", "abc");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 값입니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}