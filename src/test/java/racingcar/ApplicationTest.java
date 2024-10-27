package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import camp.nextstep.edu.missionutils.test.NsTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import racingcar.input.CheckValidInput;
import racingcar.input.InputDTO;

import java.util.List;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void is_valid_input() {
        // 빈 문자열의 경우 예외 처리
        assertThatThrownBy(() -> CheckValidInput.isValidInput(new InputDTO(List.of(""), 1)))
                .isInstanceOf(IllegalArgumentException.class);

        // 공백 문자열의 경우 예외 처리
        assertThatThrownBy(() -> CheckValidInput.isValidInput(new InputDTO(List.of(" "), 2)))
                .isInstanceOf(IllegalArgumentException.class);

        // (,) 쉼표 이외 구분자의 경우 예외 처리
        assertThatThrownBy(() -> CheckValidInput.isValidInput(new InputDTO(List.of("pobi", "nabi;helo"), 3)))
                .isInstanceOf(IllegalArgumentException.class);

        // 이름이 5자 초과인 경우 예외 처리
        assertThatThrownBy(() -> CheckValidInput.isValidInput(new InputDTO(List.of("pobi", "nabi", "javaji"), 4)))
                .isInstanceOf(IllegalArgumentException.class);

        // 차량 이름은 정상이고, 시도 횟수가 0회인 경우
        assertThatThrownBy(() -> CheckValidInput.isValidInput(new InputDTO(List.of("pobi", "nabi", "java"), 0)))
                .isInstanceOf(IllegalArgumentException.class);

        // 차량 이름은 정상이고, 시도 횟수가 음수인 경우
        assertThatThrownBy(() -> CheckValidInput.isValidInput(new InputDTO(List.of("pobi", "nabi", "pytn"), -2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void function_test() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
