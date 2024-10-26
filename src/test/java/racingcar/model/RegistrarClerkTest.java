package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingRegisterForm;

@DisplayName("등록 사무원 테스트")
class RegistrarClerkTest {

    @Test
    @DisplayName("시도할 횟수가 1보다 작은 경우 예외 테스트")
    void should_ThrowException_When_RaceRoundCountLessThan1() {
        RegistrarClerk registrarClerk = new RegistrarClerk();
        String inputCarNames = "pobi,woni";
        String inputRaceRoundCount = "0";

        assertThatThrownBy(() -> registrarClerk.register(inputCarNames, inputRaceRoundCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도할 횟수가 숫자가 아닌 경우 예외 테스트")
    void should_ThrowException_When_RaceRoundCountIsNotNumeric() {
        RegistrarClerk registrarClerk = new RegistrarClerk();
        String inputCarNames = "pobi,woni";
        String inputRaceRoundCount = "가";

        assertThatThrownBy(() -> registrarClerk.register(inputCarNames, inputRaceRoundCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상적인 입력인 경우 신청서 객체를 반환한다.")
    public void should_ReturnRacingRegisterForm_When_ValidInputGiven() {
        RegistrarClerk registrarClerk = new RegistrarClerk();
        String inputCarNames = "pobi,woni";
        String inputRaceRoundCount = "3";

        RacingRegisterForm result = registrarClerk.register(inputCarNames, inputRaceRoundCount);
        assertThat(result).isNotNull();
        assertThat(result.carNames()).containsExactly("pobi", "woni");
        assertThat(result.raceRoundCount()).isEqualTo(3);
    }
}
