package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
    void 시작_안내_문구_테스트() {
        Application.printStartMessage();
        assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void 시작_안내_문구_틀린경우_테스트() {
        Application.printStartMessage();
        assertThat(output()).doesNotContain("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void 시도_횟수_안내_문구_테스트(){
         Application.printTryCountMessage();
         assertThat(output()).contains("시도할 횟수는 몇 회인가요?");
    }

    @Test
    void 시도_횟수_안내_문구_틀린_경우_테스트(){
        Application.printTryCountMessage();
        assertThat(output()).doesNotContain("시도할 회수는 몇 회인가요?");
    }

    @Test
    void 빈_칸_입력_예외처리_테스트(){
        assertThrows(IllegalArgumentException.class, () -> Application.validateEmptyInput(""));
        assertThrows(IllegalArgumentException.class, () -> Application.validateEmptyInput(" "));
        assertThrows(IllegalArgumentException.class, () -> Application.validateEmptyInput("     "));
        assertThrows(IllegalArgumentException.class, () -> Application.validateEmptyInput(" "));
    }

    @Test
    void 빈_칸이_아닌_정상입력_예외처리_테스트(){
        assertDoesNotThrow(() -> Application.validateEmptyInput("abcd"));
    }

    @Test
    void 자동차_10대_이상_예외처리_테스트(){
        String[] names = new String[27];
        for(int i = 0; i < names.length; i++){
            names[i] = " ";
        }
        assertThrows(IllegalArgumentException.class, () -> Application.validateNamesCount(names));
    }

    @Test
    void 자동차_1대_이상_10대_이하_정상처리_테스트(){
        String[] names = new String[9];
        for(int i = 0; i < names.length; i++){
            names[i] = " ";
        }
        assertDoesNotThrow(() -> Application.validateNamesCount(names));
    }

    @Test
    void 자동차_이름_5자_초과인_경우_예외_발생(){
        String[] names = new String[]{
                "abcd",
                "abcdef"
        };
        assertThrows(IllegalArgumentException.class, () -> Application.validateNameLength(names));

        names[1] = "가나다라마바";
        assertThrows(IllegalArgumentException.class, () -> Application.validateNameLength(names));

        names[1] = "ㅁㄷㅂㄷㅇㅁ";
        assertThrows(IllegalArgumentException.class, () -> Application.validateNameLength(names));

        names[1] = "";
        assertThrows(IllegalArgumentException.class, () -> Application.validateNameLength(names));
    }

    @Test
    void 자동차_이름_5자_이하인_경우_정상처리(){
        String[] names = new String[]{
                "a",
                "bc",
                "abcd",
                "abc"
        };
        assertDoesNotThrow(() -> Application.validateNameLength(names));

        names[1] = "가나다라바";
        assertDoesNotThrow(() -> Application.validateNameLength(names));

        names[1] = "ㅁㅂㅇㄷㄹ";
        assertDoesNotThrow(() -> Application.validateNameLength(names));
    }

    @Test
    void 숫자가_입력되지_않을_경우_예외발생(){
        assertThrows(IllegalArgumentException.class, () -> Application.validateNumber("a"));
        assertThrows(IllegalArgumentException.class, () -> Application.validateNumber(""));
        assertThrows(IllegalArgumentException.class, () -> Application.validateNumber(" "));
        assertThrows(IllegalArgumentException.class, () -> Application.validateNumber("rk"));
    }

    @Test
    void 숫자가_입력될_경우_정상처리(){
        assertDoesNotThrow(() -> Application.validateNumber("1"));
        assertDoesNotThrow(() -> Application.validateNumber("0"));
        assertDoesNotThrow(() -> Application.validateNumber("-1"));
        assertDoesNotThrow(() -> Application.validateNumber("999999"));
    }

    @Test
    void 숫자가_25이하인_자연수가_아닐경우_예외발생(){
        assertThrows(IllegalArgumentException.class, () -> Application.validatePlayCount(-1));
        assertThrows(IllegalArgumentException.class, () -> Application.validatePlayCount(30));
        assertThrows(IllegalArgumentException.class, () -> Application.validatePlayCount(0));
    }

    @Test
    void 숫자가_25이하인_자연수인_경우_정상처리(){
        assertDoesNotThrow(()-> Application.validatePlayCount(1));
        assertDoesNotThrow(()-> Application.validatePlayCount(25));
        assertDoesNotThrow(()-> Application.validatePlayCount(5));
    }

    @Test
    void 정상적으로_이동횟수가_증가하는지_확인(){
        assertRandomNumberInRangeTest(
                () -> {
                    int[] expected = {1,0,1};
                    int[] move = {0,0,0};
                    Application.moveCars(move);

                    assertArrayEquals(expected, move);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 실행_결과_출력형태_일치하는지_확인(){
        String[] cars = {"abcd", "efgh", "acde"};
        int[] move = {0,1,2};

        Application.printCurrentMoves(cars, move);
        String expectedOutput = "abcd : " + System.lineSeparator() +
                "efgh : -" + System.lineSeparator() +
                "acde : --";
        assertThat(output()).isEqualTo(expectedOutput);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
