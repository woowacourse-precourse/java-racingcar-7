package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttemptCountParserTest {
    private AttemptCountParser attemptCountParser;

    @BeforeEach
    void setUp() {
        attemptCountParser = new AttemptCountParser();
    }

    @Test
    @DisplayName("유효한 시도횟수를 사용자가 입력했을때 int로 형변환 후 반환하는지 테스트")
    public void 유효한_시도횟수_입력받기_테스트(){
        //given
        String input = "3";
        int expectedAttemptCount = 3;
        //when
        int actualAttemptCount =  attemptCountParser.validateAttemptCount(input);
        //then
        Assertions.assertThat(actualAttemptCount).isEqualTo(expectedAttemptCount);
    }

    @Test
    @DisplayName("시도횟수가 0이하일 경우 IllegalArgumentException 발생")
    public void 시도횟수_음수일경우_입력받기_예외테스트(){
        String input = "-3";

        Assertions.assertThatThrownBy(()->attemptCountParser.validateAttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 0보다 커야합니다.");
    }

    @Test
    @DisplayName("시도횟수가 숫자가 아닐 경우에 IllegalArgumentException 발생")
    public void 시도횟수_숫자가아닐경우_입력받기_예외테스트(){
        String input = "ksy";

        Assertions.assertThatThrownBy(()->attemptCountParser.validateAttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도횟수가 숫자가 아닙니다.");
    }



}