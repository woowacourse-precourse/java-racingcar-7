package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingRegisterForm;

@DisplayName("신청 폼 생성자 테스트")
class RacingRegisterFormFactoryTest {

    @Test
    @DisplayName("시도할 횟수가 1보다 작은 경우 예외 테스트")
    void should_ThrowException_When_RaceRoundCountLessThan1() {
        String inputCarNames = "pobi,woni";
        String inputRaceRoundCount = "0";

        assertThatThrownBy(() -> RacingRegisterFormFactory.createFrom(inputCarNames, inputRaceRoundCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도할 횟수가 숫자가 아닌 경우 예외 테스트")
    void should_ThrowException_When_RaceRoundCountIsNotNumeric() {
        String inputCarNames = "pobi,woni";
        String inputRaceRoundCount = "가";

        assertThatThrownBy(() -> RacingRegisterFormFactory.createFrom(inputCarNames, inputRaceRoundCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상적인 입력인 경우 신청 폼 객체를 반환한다.")
    public void should_ReturnRacingRegisterForm_When_ValidInputGiven() {
        String inputCarNames = "pobi,woni";
        String inputRaceRoundCount = "3";

        RacingRegisterForm result = RacingRegisterFormFactory.createFrom(inputCarNames, inputRaceRoundCount);
        assertThat(result).isNotNull();
        assertThat(result.carNames()).containsExactly("pobi", "woni");
        assertThat(result.raceRoundCount()).isEqualTo(3);
    }
}
