package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class InputTest extends NsTest {
    private InputController inputController = new InputController();

    private void command(String... args) {
        byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }


    // 입력테스트는 개별 실행 시 동작하나, 전체 실행 시 System.in이 공유되어 테스트 실패
    @Test
    void 입력_테스트_자동차목록() {
        command("pobi,woni");
        assertSimpleTest(() -> {
            assertThat(inputController.readCarNames()).containsExactly("pobi", "woni");
        });
    }

    @Test
    void 입력_테스트_자동차목록_예외_빈칸() {
        command("pobi,,woni");
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> inputController.readCarNames())
                .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 입력_테스트_자동차목록_예외_글자초과() {
        command("pobi,woni,123456");
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> inputController.readCarNames())
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 입력_테스트_자동차목록_예외_중복() {
        command("pobi,woni,pobi");
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> inputController.readCarNames())
                .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 입력_테스트_시도횟수() {
        command("5");
        assertSimpleTest(() -> {
            assertThat(inputController.readTryCount()).isEqualTo(5);
        });
    }

    @Test
    void 입력_테스트_시도횟수_예외() {
        command("a");
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> inputController.readTryCount())
                .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
