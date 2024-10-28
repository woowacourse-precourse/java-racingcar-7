package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorMessage;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.service.GameService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameServiceTest {

    @DisplayName("정상적인 시도 횟수 입력시 자동차 경주 서비스가 생성된다.")
    @Test
    public void gameService_ValidAttempts_ShouldBeCreated() {
        Cars cars = new Cars("pobi,woni");
        GameService gameService = new GameService(cars, "5");

        assertThat(gameService).isNotNull();
        assertThat(gameService.getAttempts()).isEqualTo(5);
    }

    @DisplayName("정상적으로 게임의 승리자가 출력되는지 확인한다.")
    @Test
    public void getWinners_ValidPositions_ShouldReturnWinners() {
        Cars cars = new Cars("pobi,woni");
        GameService gameService = new GameService(cars, "5");

        // 예시로 자동차의 위치를 수동으로 설정합니다.
        cars.getCars().get(0).move(); // pobi가 한 번 이동
        cars.getCars().get(1).move(); // woni가 한 번 이동
        cars.getCars().get(1).move(); // woni가 한 번 더 이동

        List<Car> winners = gameService.getWinners();
        assertThat(winners).hasSize(1);
        assertThat(winners.getFirst().getName()).isEqualTo("woni");
    }

    @DisplayName("시도 횟수가 비어 있을 경우 예외가 발생한다.")
    @Test
    public void validateAttempts_EmptyAttempts_ShouldThrowException() {
        Cars cars = new Cars("pobi,woni");

        assertThatThrownBy(() -> new GameService(cars, ""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_ATTEMPTS.getMessage());
    }

    @DisplayName("문자 입력 시 예외가 발생한다.")
    @Test
    public void validateAttempts_CharacterInput_ShouldThrowException() {
        Cars cars = new Cars("pobi,woni");

        assertThatThrownBy(() -> new GameService(cars, "a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_ATTEMPTS.getMessage());
    }

    @DisplayName("음수 입력 시 예외가 발생한다.")
    @Test
    public void validateAttempts_NegativeNumber_ShouldThrowException() {
        Cars cars = new Cars("pobi,woni");

        assertThatThrownBy(() -> new GameService(cars, "-3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_ATTEMPTS.getMessage());
    }

    @DisplayName("소수 입력 시 예외가 발생한다.")
    @Test
    public void validateAttempts_FloatInput_ShouldThrowException() {
        Cars cars = new Cars("pobi,woni");

        assertThatThrownBy(() -> new GameService(cars, "1.5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_ATTEMPTS.getMessage());
    }
}