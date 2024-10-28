package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private InputController inputController = new InputController();

    // 입력 테스트 ----------------------------------------------
    // nsTest의 command 메서드만 따로 가져옴
    private void command(String... args) {
        byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Test
    void 입력_테스트_자동차목록() {
        assertSimpleTest(() -> {
            command("pobi,woni");
            assertThat(inputController.readCarNames()).containsExactly("pobi", "woni");
        });
    }

    @Test
    void 입력_테스트_자동차목록_예외_빈칸() {
        assertSimpleTest(() -> {
            command("pobi,,woni");
            assertThatThrownBy(() -> inputController.readCarNames())
                .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 입력_테스트_자동차목록_예외_글자초과() {
        assertSimpleTest(() -> {
            command("pobi,woni,123456");
            assertThatThrownBy(() -> inputController.readCarNames())
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 입력_테스트_자동차목록_예외_중복() {
        assertSimpleTest(() -> {
            command("pobi,woni,pobi");
            assertThatThrownBy(() -> inputController.readCarNames())
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 입력_테스트_시도횟수() {
        assertSimpleTest(() -> {
            command("5");
            assertThat(inputController.readTryCount()).isEqualTo(5);
        });
    }

    @Test
    void 입력_테스트_시도횟수_예외_문자() {
        assertSimpleTest(() -> {
            command("a");
            assertThatThrownBy(() -> inputController.readTryCount())
                .isInstanceOf(IllegalArgumentException.class);
        });
    }

    // 랜덤 테스트 ----------------------------------------------

    // 출력 결과 테스트 ----------------------------------------------

    // 통합 테스트 ----------------------------------------------
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
}
