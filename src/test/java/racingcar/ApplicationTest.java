package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;


    @Test
    void 콘솔_파라미터_테스트() {
        assertSimpleTest(() -> {
            run("koo,sang,woo", "3");
        });
    }

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
    @DisplayName("이름이 공백인 값의 자동차가 있으면 예외 리턴")
    void 이름값_공백_예외() {
        assertThatThrownBy(() -> {
            assertSimpleTest(() -> {
                run(",koo,sangwoo,koo", "5");

            });
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("자동차명은 공백이 될 수 없습니다.\n" +
                ", 의 위치를 확인하세요");
    }

    @Test
    @DisplayName("5자가 넘으면 예외 발생")
    void 이름_글자제한_초과() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> {

                run("kooooo,sang,woo", "3");
            }).isInstanceOf(IllegalArgumentException.class).hasMessage("이름은 다섯글자를 넘을 수 없습니다.\n " +
                    "잘못된 이름 : kooooo");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("실행 횟수를 잘못 입력했을 때")
    void 실행_횟수_입력_오류() {
        assertThrows(IllegalArgumentException.class, () -> {
            assertSimpleTest(() -> {
                run("koo,sang,woo","4번");
            });
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
