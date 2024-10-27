package racingcar.boundary;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import racingcar.Application;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class NamesValueTest extends NsTest {

    @Test
    void 자동차이름_길이_테스트() {
        assertSimpleTest(() ->
                run("pobi,woni,abcd5", "1") // 자동차 이름이 정확히 5자
        );
        assertThat(output()).doesNotContain("자동차 이름은 1자 이상 5자 이하로 입력해 주세요.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
