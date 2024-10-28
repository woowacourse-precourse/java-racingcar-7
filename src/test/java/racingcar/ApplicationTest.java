package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorCode;

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

    @Test
    @DisplayName("전체적인 기능 테스트-세 명의 count가 모두 다를 경우")
    void 전체적_정상_기능_테스트_0(){

        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains("pobi : -", "woni : --","jun : ---", "최종 우승자 : jun");
                },
                1,3,4,5,6,4,2,7,9
        );

    }

    @Test
    @DisplayName("전체적인 기능 테스트-세 명의 count가 상위 2명만 같을 경우")
    void 전체적_정상_기능_테스트_1(){

        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains("pobi : -", "woni : ---","jun : ---", "최종 우승자 : woni, jun");
                },
                1,8,4,5,6,4,2,7,9
        );

    }

    @Test
    @DisplayName("전체적인 기능 테스트-세 명의 count가 하위 2명만 같을 경우")
    void 전체적_정상_기능_테스트_2(){

        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains("pobi : --", "woni : ---","jun : --", "최종 우승자 : woni");
                },
                4,7,4,5,6,4,2,7,3
        );

    }

    @Test
    @DisplayName("사용자의 차 이름 입력값이 빈 값일 떄 예외처리")
    void 사용자_입력값_빈값(){

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorCode.CANT_CONVERT_CAR_NAME_WITH_NULL_OR_BLANK.getMessage()));


    }

    @Test
    @DisplayName("사용자의 차 이름 입력값이 5보다 클때 예외처리")
    void 사용자_입력값_길이_5초과(){

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("java,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorCode.CANT_CAR_NAME_LENGTH_EXCEED_FIVE.getMessage()));


    }

    @Test
    @DisplayName("사용자의 시도 횟수 입력값이 숫자가 아닐 때 예외처리")
    void 시도횟수_숫자_X(){

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,joon", "hi"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorCode.CANT_CONVERT_TO_INTEGER.getMessage()));


    }

    @Test
    @DisplayName("사용자의 시도 횟수 입력값이 0일 때 예외 처리")
    void 시도횟수_0(){

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,joon", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorCode.CANT_TRY_COUNT_UNDER_ZERO.getMessage()));

    }

    @Test
    @DisplayName("사용자의 시도 횟수 입력값이 음수일 때 예외 처리")
    void 시도횟수_음수(){

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,joon", "-3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorCode.CANT_TRY_COUNT_UNDER_ZERO.getMessage()));

    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
