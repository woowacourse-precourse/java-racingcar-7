package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.util.ExceptionChecker;

class ApplicationTest2 extends NsTest {


    @Test
    void 한영_숫자가_이름일때_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,김지훈1,king갓", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "김지훈1 : ", "king갓 : ", "최종 우승자 : pobi");
                }, 4, 3
        );
    }


    @Test
    void 이름에_공백을_입력시_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에_공백을_입력시_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_특수문자_사용시() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni.john", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 한글_이름_글자수_초과시() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("포비,가나다, 가나다라마바", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 영문_이름_글자수_초과시() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,hong,  ironman", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 한영숫자_이름_글자수_초과시() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("hong1, 재홍2, hong홍3", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    //    @Test
//    void 라운드_공백_입력시_1() {
//        assertSimpleTest(() ->
//            assertThatThrownBy(() -> runException("pobi, hong, kim", ""))
//                .isInstanceOf(IllegalArgumentException.class)
//        );
//    }
    @Test
    void 라운드_공백_입력시_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> ExceptionChecker.validateRoundInput(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드_공백_입력시_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, hong, kim", " "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 라운드_0_입력시() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, hong, kim", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}