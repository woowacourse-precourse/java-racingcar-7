package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 입력테스트(){
        assertSimpleTest(() -> {
                    run("pobi,woni,jun","1");
                    assertThat(output()).contains(
                            "pobi : -",
                            "woni : -",
                            "jun : -"
                            );
                }
        );
        assertSimpleTest(() -> {
                    run("pobi,woni,jun","2");
                    assertThat(output()).contains(
                            "pobi : -",
                            "woni : -",
                            "jun : -"
                            ,"pobi : --",
                            "woni : --",
                            "jun : --"

                    );
                }
        );
        assertSimpleTest(() -> {
                    run("pobi,woni,jun","3");
                    assertThat(output()).contains(
                            "pobi : -",
                            "woni : -",
                            "jun : -"
                            ,"pobi : --",
                            "woni : --",
                            "jun : --"
                            ,"pobi : ---",
                            "woni : ---",
                            "jun : ---"
                    );
                }
        );
    }

    @Test
    void 예외_테스트() {

    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}

