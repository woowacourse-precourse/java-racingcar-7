package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomApplicationTest extends NsTest{

    @Test
    void SIMULATE_JUN_WIN(){
        assertRandomNumberInRangeTest(
            ()->{
                run("pobi,woni,jun", "3");

                assertThat(output()).contains("pobi : -", "woni : ", "jun : -");
                assertThat(output()).contains("pobi : --:", "woni : -", "jun : --");
                assertThat(output()).contains("pobi : --", "woni : --", "jun : ---", "최종 우승자 : jun");
            },
            5, 3, 6,
            4, 5,7,
            2,4,8
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
