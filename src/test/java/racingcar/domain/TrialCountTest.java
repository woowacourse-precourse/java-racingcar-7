package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TrialCountTest {
    @DisplayName("사용자는 몇 번의 이동을 할 것인지 입력할 수 있다.")
    @Test
    void inputUserTryCount() throws Exception{
        String userInput = "3";
        TrialCount trialCount = new TrialCount(userInput);
        Assertions.assertThat(trialCount.getTrialCount()).isEqualTo(3);
    }

    @DisplayName("이동할 횟수는 자연수여야 합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"0","하이","!!","-1","현투"})
    void validateMovingCountIsNatural(String input) throws Exception{
        Assertions.assertThatThrownBy(() -> new TrialCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동할 횟수는 자연수여야 합니다.");
    }

}