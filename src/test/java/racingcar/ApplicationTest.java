package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Race;
import racingcar.validation.InputValidator;
import racingcar.view.InputView;

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
    void 자동차_이름_중복_예외_테스트() {
        Race race = new Race();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            race.setCars("min,min,min");
        });
    }

    @Test
    void 실행_횟수_음수_입력_예외_테스트() {
        InputValidator inputValidator = new InputValidator();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateRounds("-1");
        });
    }

    @Test
    void 실행_횟수_Integer_범위_초과_예외_테스트() {
        InputValidator inputValidator = new InputValidator();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateRounds("2200000000");
        });
    }

    @Test
    void 빈_문자열_입력_예외_테스트() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputView.requestInput("Test");
        });
    }

    @Test
    void Null_입력_예외_테스트() {
        assertThatThrownBy(() -> InputView.requestInput(null))
                .isInstanceOf(IllegalArgumentException.class);
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
