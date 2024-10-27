package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingRegisterForm;
import racingcar.model.move.RandomMoveStrategy;

@DisplayName("자동차 경주 등록원 테스트")
class RegistrarClerkTest {

    @Test
    @DisplayName("신청 폼 객체가 잘못된 경우 예외 테스트")
    void should_ThrowException_When_RegisterFormIsNull() {
        assertThatThrownBy(() ->  new RegistrarClerk().register(null, new RandomMoveStrategy()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("움직임 전략 객체가 잘못된 경우 예외 테스트")
    void should_ThrowException_When_MoveStrategyIsNull() {
        String inputCarNames = "pobi,woni";
        String inputRaceRoundCount = "3";
        RacingRegisterForm registerForm = RacingRegisterFormFactory.create(inputCarNames, inputRaceRoundCount);
        assertThatThrownBy(() ->  new RegistrarClerk().register(registerForm, null))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("정상적인 신청인 경우 자동차 경주 객체를 반환한다.")
    public void should_ReturnCarRace_When_ValidInputGiven() {
        String inputCarNames = "pobi,woni";
        String inputRaceRoundCount = "3";
        RacingRegisterForm registerForm = RacingRegisterFormFactory.create(inputCarNames, inputRaceRoundCount);
        RegistrarClerk registrarClerk = new RegistrarClerk();
        CarRace carRace = registrarClerk.register(registerForm, new RandomMoveStrategy());

        assertThat(carRace).isNotNull();
    }
}
