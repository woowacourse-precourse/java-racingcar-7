package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceServiceTest {

    private final RaceService raceService = new RaceService();

    @Test
    @DisplayName("시도 횟수가 정상적인 자연수로 반환되는지 테스트")
    void testFindAttemptNumSuccessfully() {
        String inputNum = "5";

        int attemptNum = raceService.findAttemptNum(inputNum);

        assertThat(attemptNum).isEqualTo(5);
    }

    @Test
    @DisplayName("시도 횟수가 비어있을 때 IllegalArgumentException이 발생하는지 테스트")
    void testEmptyAttemptThrowsException() {

        String inputBlank = "";

        assertThatThrownBy(() -> raceService.findAttemptNum(inputBlank))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수를 입력해 주세요.");
    }

    @Test
    @DisplayName("입력받은 시도 횟수가 자연수가 아닐 때 IllegalArgumentException이 발생하는지 테스트")
    void testNonNaturalAttemptThrowsException() {
        String inputString = "test";

        assertThatThrownBy(() -> raceService.findAttemptNum(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효한 시도 횟수를 입력해 주세요(자연수).");
    }

}
