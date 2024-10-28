package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.Application;

public class RacingControllerTest extends NsTest {
    static final String INVALID_RACECOUNT_MASSAGE = "시도 횟수는 1부터 20까지의 정수로 입력해주세요.";
    static final String VALID_CARNAMES = "pobi,woni,jun";

    @ParameterizedTest(name = "{index}: {2}")
    @MethodSource("invalidCounts")
    @DisplayName("유효하지 않은 경주 횟수 처리")
    void setUpRaceTest_invalidInput(String carNames, String raceCount, String message, String exceptionMessage) {
        assertSimpleTest(
                () -> {
                    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                            () -> runException(carNames, raceCount));
                    assertThat(e.getMessage()).isEqualTo(exceptionMessage);
                }
        );
    }

    static Stream<Arguments> invalidCounts() {
        return Stream.of(
                Arguments.of(VALID_CARNAMES, "a", "문자", INVALID_RACECOUNT_MASSAGE),
                Arguments.of(VALID_CARNAMES, "100", "20 초과", INVALID_RACECOUNT_MASSAGE),
                Arguments.of(VALID_CARNAMES, "-1", "0 이하", INVALID_RACECOUNT_MASSAGE),
                Arguments.of(VALID_CARNAMES, "1.5", "정수가 아닌 수", INVALID_RACECOUNT_MASSAGE),
                Arguments.of(VALID_CARNAMES, "\n", "공백", INVALID_RACECOUNT_MASSAGE)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
