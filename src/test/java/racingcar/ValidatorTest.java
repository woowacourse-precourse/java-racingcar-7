package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    private RacingService racingService;

    @ParameterizedTest(name = "{1}")
    @CsvSource({
            "'aaaaaaa,bbbbbbb,ccccccc,ddddddd', 자동차 이름이 5글자 초과인 경우",
            "'a,a,b,c,d', 자동차 이름이 중복된 경우",
            "'a,,,b,,,', 자동차 이름이 공백인 경우"
    })
    void 자동차_이름_유효성_테스트(String carNameInput, String description) {
        assertThatThrownBy(() -> {
            racingService = new RacingService(carNameInput, "4");
            racingService.startRace();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{1}")
    @CsvSource({
            "'a', 시도할 횟수가 숫자가 아닌 경우",
            "'-1', 시도할 횟수가 음수인 경우"
    })
    void 시도할_횟수_유효성_테스트(String maxTurnInput, String description) {
        assertThatThrownBy(() -> {
            racingService = new RacingService("a,b,c", maxTurnInput);
            racingService.startRace();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
