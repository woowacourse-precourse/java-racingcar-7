package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingRegisterForm;

@DisplayName("자동차 경주 등록 서비스 객체 테스트")
class RegistrationServiceTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    @DisplayName("시도할 횟수 입력값이 숫자가 아닌 경우 예외가 발생한다.")
    void should_ThrowException_When_RaceRoundCountInputIsNotValid() {
        String testInput = "pobi,woni\na";
        mockSystemInput(testInput);

        RegistrationService registrationService = new RegistrationService();
        assertThatThrownBy(registrationService::register)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도할 횟수 입력값이 1보다 작은 경우 예외가 발생한다.")
    void should_ThrowException_When_RaceRoundCountIsLessThanOne() {
        String testInput = "pobi,woni\n0";
        mockSystemInput(testInput);

        RegistrationService registrationService = new RegistrationService();
        assertThatThrownBy(registrationService::register)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상적인 입력인 경우 신청 폼 객체를 반환한다.")
    void should_ReturnRacingRegisterForm_When_ValidInputGiven() {
        String testInput = "pobi,woni\n3";
        mockSystemInput(testInput);

        RegistrationService registrationService = new RegistrationService();
        RacingRegisterForm result = registrationService.register();
        assertThat(result).isNotNull();
        assertThat(result.carNames()).containsExactly("pobi", "woni");
        assertThat(result.raceRoundCount()).isEqualTo(3);
    }

    private void mockSystemInput(String mockInput) {
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));
    }
}
