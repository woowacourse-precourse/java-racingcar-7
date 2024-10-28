package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.CarNameInput;

import java.util.List;

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
    @DisplayName("앞 뒤 공백 처리")
    @Test
    void 자동차_이름_테스트1(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi ,  woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @DisplayName("빈문자열 예외처리")
    @Test
    void 자동차_이름_예외_테스트1(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

//    @DisplayName("null 예외처리")
//    @Test
//    void 자동차_이름_예외_테스트2(){
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> runException(null, "1"))
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }

    @DisplayName("문자열 포맷 예외처리")
    @Test
    void 자동차_이름_예외_테스트3(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("시도횟수 횟수 예외처리")
    @Test
    void 시도횟수_예외_테스트1(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, jiho", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("시도횟수 범위 예외처리")
    @Test
    void 시도횟수_예외_테스트2(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, jiho", "101"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @DisplayName("문자열 예외처리")
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
}
