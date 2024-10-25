package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 자동차_동일_이름_테스트(){
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("java,java"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 시도_횟수_테스트1(){
        assertSimpleTest(()->{
            assertThatThrownBy(()->runException("java,jre,jdk","0"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 시도_횟수_테스트2(){
        assertSimpleTest(()->{
            assertThatThrownBy(()->runException("java,jre,jdk","-1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 시도_횟수_테스트3(){
        assertSimpleTest(()->{
            assertThatThrownBy(()->runException("java,jre,jdk","c"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 성공_테스트(){
        assertSimpleTest(()->{
            run("java,char,j","5");
        });
    }

    @Test
    void 콤마만_입력(){
        assertSimpleTest(()->{
            assertThatThrownBy(()->runException(",","5"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 이름_입력_안함(){
        assertSimpleTest(()->{
            assertThatThrownBy(()->runException("\n"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 이름_앞뒤_공백_테스트(){
        assertSimpleTest(()->{
            run("java  , char,  j  ","5");
        });
    }
}
