package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.utils.Constant;
import racingcar.utils.Validator;

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
    void 자동차의_이름이_5자_초과일_때() {
        Validator validator = new Validator();
        ArrayList<String> carNames = new ArrayList<>(List.of("Faker", "ShowMaker", "Chovy"));

        assertThatThrownBy(() -> validator.validateInputCarName(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constant.CAR_NAME_LENGTH_ERROR);

    }

    @Test
    void 입력받은_이동_횟수가_숫자가_아닐_때 () {
        Validator validator = new Validator();
        String gameCount = "롤드컵 보고싶다";

        assertThatThrownBy(() -> validator.validateInputGameCount(gameCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constant.GAME_COUNT_FORMAT_ERROR);

    }
    @Test
    void 입력받은_이동_횟수가_없을_때 () {
        Validator validator = new Validator();
        String gameCount = "";

        assertThatThrownBy(() -> validator.validateInputGameCount(gameCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constant.GAME_COUNT_FORMAT_ERROR);

    }

    @Test
    void 입력받은_이동_횟수가_음수일_때() {
        Validator validator = new Validator();
        String gameCount = "-1";

        assertThatThrownBy(() -> validator.validateInputGameCount(gameCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constant.GAME_COUNT_POSITIVE_ERROR);

    }

    @Test
    void 아무_자동차의_이름도_입력하지_않았을_때() {
        Validator validator = new Validator();
        ArrayList<String> carNames = new ArrayList<>(List.of(""));

        assertThatThrownBy(() -> validator.validateInputCarName(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constant.CAR_NAME_BLANK_ERROR);

    }

    @Test
    void 여러_대_자동차_중_하나라도_이름이_공백일_때() {
        Validator validator = new Validator();
        ArrayList<String> carNames = new ArrayList<>(List.of("Faker", "                ", "Chovy"));

        assertThatThrownBy(() -> validator.validateInputCarName(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constant.CAR_NAME_BLANK_ERROR);

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
