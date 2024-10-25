package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.model.exception.*;
import racingcar.model.service.InputService;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputServiceTest extends NsTest {

    @Test
    void 예외_테스트_이름_입력값_누락() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(MissingInputValueException.class)
                        .hasMessageContaining("입력값이 누락되었습니다.")
        );
    }

    @Test
    void 예외_테스트_횟수_입력값_누락() {
        InputService inputService = new InputService();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputService.validator("pobi,woni", ""))
                        .isInstanceOf(MissingInputValueException.class)
                        .hasMessageContaining("입력값이 누락되었습니다.")
        );
    }

    @Test
    void 예외_테스트_횟수_입력값_0() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(InvalidAttemptCountException.class)
                        .hasMessageContaining("시도할 횟수는 0일 수 없습니다.")
        );
    }

    @Test
    void 예외_테스트_이름_입력값_5초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "5"))
                        .isInstanceOf(CarNameLengthExceededException.class)
                        .hasMessageContaining("자동차 이름의 입력값은 최대 5자입니다.")
        );
    }

    @Test
    void 예외_테스트_횟수_입력값_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaj", "aaaa"))
                        .isInstanceOf(InvalidAttemptCountException.class)
                        .hasMessageContaining("시도할 횟수는 숫자여야합니다.")
        );
    }

    @Test
    void 이름_입력값_분리() {
        InputService inputService = new InputService();
        assertSimpleTest(() -> {
            assertThat(inputService.splitCarValue("pobi,javaj,123,44444"))
                    .isEqualTo(Arrays.asList("pobi", "javaj", "123", "44444"));
        });
    }

    @Test
    void 횟수_입력값_숫자_검증() {
        InputService inputService = new InputService();
        assertSimpleTest(() -> {
            assertThat(inputService.isValidAttemptCount("11")).isTrue();
        });
    }

    @Test
    void 예외_테스트_이름_입력값_갯수_검증() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "2"))
                        .isInstanceOf(InvalidCarCountException.class)
                        .hasMessageContaining("자동차는 1개 일 수 없습니다.")
        );
    }

    @Test
    void 예외_테스트_중복_이름() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi,woni", "2"))
                        .isInstanceOf(DuplicateCarNameException.class)
                        .hasMessageContaining("자동차 이름이 중복될 수 없습니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
