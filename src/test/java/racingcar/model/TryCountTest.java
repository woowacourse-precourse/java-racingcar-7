package racingcar.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;

public class TryCountTest extends NsTest {

    @ParameterizedTest
    @DisplayName("불가능한 시행횟수를 확인합니다.")
    @ValueSource(strings = {"", "\n", " ", "    ", "ㅇㅇ", "-1", "-10", "0.1", "1.9"})
    void tryCount_테스트(String input) {
        Assertions.assertThatThrownBy(() -> new TryCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
