package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validators.RoundValidator;


class RoundTest extends NsTest {

    @Test
    @DisplayName("사용자가 횟수를 1회 미만으로 적었을 때")
    void INPUT_IS_LESS_THEN_1() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                RoundValidator.countValidate(Collections.singletonList(0))
        );
        assert(exception.getMessage().equals("횟수는 0 이상이어야 합니다."));
    }

    @Test
    @DisplayName("사용자가 게임 횟수를 안 적었을 때")
    void ROUND_WITH_EMPTY_INPUT() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                RoundValidator.StringValidate(Collections.singletonList(""))
        );
        assertEquals("입력이 필요합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("시도할 횟수에서 문자열이 들어왔을 때")
    void INCORRECT_INPUT_WITH_STRING() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                RoundValidator.StringValidate(Collections.singletonList("a"))
        );

        assertEquals("숫자를 입력해주세요.", exception.getMessage());
    }


    @Override
    protected void runMain() {

    }
}

