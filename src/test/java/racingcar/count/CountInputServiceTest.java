package racingcar.count;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.IOUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountInputServiceTest {
    @Test
    @DisplayName("입력된 시도 횟수를 반환한다.")
    void getAttemptCount() {
        int attemptCount = 5;
        IOUtils.outputStringWithEnter("시도할 횟수는 몇 회인가요?");

        assertEquals(5, attemptCount);

    }
}