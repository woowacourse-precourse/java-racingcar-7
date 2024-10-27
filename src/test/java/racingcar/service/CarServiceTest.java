package racingcar.service;

import static org.assertj.core.api.Assertions.*;
import static racingcar.exception.ErrorMessage.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.dto.RaceDto;

class CarServiceTest {

    private CarService carService;

    @BeforeEach
    void init() {
        carService = new CarService();
    }

    @RepeatedTest(10)
    @DisplayName("자동차 경주 완료수 RaceDto 반환")
    void playGame() {
        List<String> carNames = List.of("pobi", "woni", "jun");

        RaceDto raceDto = carService.playGame("pobi,woni,jun", 5);

        String[] winnerCarNames = raceDto.getWinnerCarName().split(",");

        assertThat(raceDto.getRaceRounds()).hasSize(5);
        assertThat(raceDto.getWinnerCarName()).isNotNull();
        assertThat(carNames).containsAll(Arrays.asList(winnerCarNames));
    }

    @Test
    @DisplayName("자동차 이름 길이가 5초과시 예외 발생")
    void carNameLengthException() {
        assertThatThrownBy(() -> carService.playGame("proshess,woni", 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_TOO_LONG);
    }
    
}