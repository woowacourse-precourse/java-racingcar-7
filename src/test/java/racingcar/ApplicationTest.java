package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void setUp() {
        Application.carNameList.clear();
        Application.attemptCount = 0;
        Application.carWinCounts.clear();
    }

    @AfterEach
    void closeConsole() {
        Console.close();
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
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    //정상 기능 테스트
    @Test
    void 기능_테스트_우승자_여러명() {
        assertRandomNumberInRangeTest(() -> {
                    run("pobi,woni,jun", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "jun : -", "최종 우승자 : pobi, jun");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 기능_테스트_시도_여러번_우승자_한명() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    //첫 번째 시도 출력
                    assertThat(output()).contains("pobi : -", "woni : -");

                    //두 번째 시도 출력
                    assertThat(output()).contains("pobi : ", "woni : -");

                    //세 번째 시도 출력
                    assertThat(output()).contains("pobi : ", "woni : ");

                    //최종 우승자 출력
                    assertThat(output()).contains("최종 우승자 : woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    void 기능_테스트_시도_여러번_우승자_여러명() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    //첫 번째 시도 출력
                    assertThat(output()).contains("pobi : -", "woni : -", "jun : ");

                    //두 번째 시도 출력
                    assertThat(output()).contains("pobi : ", "woni : ", "jun : ");

                    //세 번째 시도 출력
                    assertThat(output()).contains("pobi : ", "woni : -", "jun : ");

                    //최종 우승자 출력
                    assertThat(output()).contains("최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, STOP,
                STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기능_테스트_자동차_한대_1시도() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    //첫 번째 시도 출력
                    assertThat(output()).contains("pobi : -");

                    //최종 우승자 출력
                    assertThat(output()).contains("최종 우승자 : pobi");
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 기능_테스트_자동차_한대_1시도_2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    //첫 번째 시도 출력
                    assertThat(output()).contains("pobi : ");

                    //최종 우승자 출력
                    assertThat(output()).contains("최종 우승자 : pobi");
                },
                STOP
        );
    }

    @Test
    void 기능_테스트_자동차_한대_2시도() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "2");
                    //첫 번째 시도 출력
                    assertThat(output()).contains("pobi : -");

                    //두 번째 시도 출력
                    assertThat(output()).contains("pobi : ");

                    //최종 우승자 출력
                    assertThat(output()).contains("최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기능_테스트_자동차_한대_2시도_2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "2");
                    //첫 번째 시도 출력
                    assertThat(output()).contains("pobi : ");

                    //두 번째 시도 출력
                    assertThat(output()).contains("pobi : ");

                    //최종 우승자 출력
                    assertThat(output()).contains("최종 우승자 : pobi");
                },
                STOP, STOP
        );
    }

    //시도 회수 예외 테스트
    @Test
    void 시도_회수_공란_예외_테스트() {
        //given
        String input = "pobi,woni,jun\n\n";

        //when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //then
        assertThatThrownBy(Application::inputAndValidate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_회수_0_예외_테스트() {
        //given
        String input = "pobi,woni,jun\n0\n";

        //when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //then
        assertThatThrownBy(Application::inputAndValidate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_회수_문자_예외_테스트() {
        //given
        String input = "pobi,woni,jun\no\n";

        //when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //then
        assertThatThrownBy(Application::inputAndValidate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_회수_공백_예외_테스트() {
        //given
        String input = "pobi,woni,jun\n \n";

        //when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //then
        assertThatThrownBy(Application::inputAndValidate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_회수_공백과_숫자_예외_테스트() {
        //given
        String input = "pobi,woni,jun\n 1\n";

        //when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //then
        assertThatThrownBy(Application::inputAndValidate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_회수_공백과_문자_예외_테스트() {
        //given
        String input = "pobi,woni,jun\n r\n";

        //when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //then
        assertThatThrownBy(Application::inputAndValidate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_회수_공백과_숫자들_예외_테스트() {
        //given
        String input = "pobi,woni,jun\n 1 2\n";

        //when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //then
        assertThatThrownBy(Application::inputAndValidate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_회수_공백과_문자들_예외_테스트() {
        //given
        String input = "pobi,woni,jun\n rr df s\n";

        //when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //then
        assertThatThrownBy(Application::inputAndValidate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_회수_공백과_숫자_문자_예외_테스트() {
        //given
        String input = "pobi,woni,jun\n 1 r\n";

        //when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //then
        assertThatThrownBy(Application::inputAndValidate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_회수_int_범위초과_예외_테스트() {
        //given
        String input = "pobi,woni,jun\n" + (Integer.MAX_VALUE + 1) + "\n";

        //when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //then
        assertThatThrownBy(Application::inputAndValidate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_회수_음수_예외_테스트() {
        //given
        String input = "pobi,woni,jun\n-1\n";

        //when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //then
        assertThatThrownBy(Application::inputAndValidate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    //경주 자동차 이름 유효성 테스트
    @Test
    void 경주_자동차_입력_기능_테스트() {
        //given
        String input = "pobi,woni,jun\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        Application.inputAndValidate();

        //then
        assertThat(Application.carNameList)
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 경주_자동차_입력_띄어쓰기_포함_기능_테스트() {
        //given
        String input = "pobi, wo ni, jun \n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        Application.inputAndValidate();

        //then
        assertThat(Application.carNameList)
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 경주_자동차_입력_숫자_포함_기능_테스트() {
        //given
        String input = "jun1,j2un,jun3\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        Application.inputAndValidate();

        //then
        assertThat(Application.carNameList)
                .containsExactly("jun1", "j2un", "jun3");
    }

    @Test
    void 경주_자동차_입력_한글_기능_테스트() {
        //given
        String input = "하 나,둘1,셋\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        Application.inputAndValidate();

        //then
        assertThat(Application.carNameList)
                .containsExactly("하나", "둘1", "셋");
    }

    @Test
    void 경주_자동차_입력_동일이름은_하나만_테스트() {
        //given
        String input = "pobi,pobi,하나,하나\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        Application.inputAndValidate();

        //then
        assertThat(Application.carNameList)
                .containsExactly("pobi", "하나");
    }

    @Test
    void 경주_자동차_길이초과_예외_테스트() {
        //given
        String input = "pobipobi,woni\n3\n";

        //when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //then
        assertThatThrownBy(Application::inputAndValidate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 경주_자동차_특수문자_포함_예외_테스트() {
        //given
        String input = "jun&,ju%\n3\n";

        //when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //then
        assertThatThrownBy(Application::inputAndValidate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 경주_자동차_쉼표_여러개_예외_테스트() {
        //given
        String input = "jun,,,pobi\n3\n";

        //when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //then
        assertThatThrownBy(Application::inputAndValidate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
