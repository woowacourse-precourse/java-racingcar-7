package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.dto.RacingCarResponse;

class RacingCarServiceTest {

    private RacingCarService racingCarService;
    private List<String> nameValues;

    @BeforeEach
    void setUp() {
        racingCarService = new RacingCarService();
        nameValues = List.of("pobi", "woni");
    }

    @DisplayName("자동차 경주는 참가 자동차 이름 목록과 총 라운드 수를 받아 시작한다")
    @Test
    void 자동차_경주_시작_성공() {
        RacingCarResponse response = racingCarService.startRacing(nameValues, 2);

        assertThat(response.winnerNames()).containsAnyOf("pobi", "woni");
        assertThat(response.racingResults()).hasSize(2);
    }

    @DisplayName("자동차 경주는 1명 이상 참가해야 시작할 수 있다")
    @Test
    void 자동차_경주_시작_실패_라운드_없음() {
        assertThatThrownBy(() -> racingCarService.startRacing(List.of(), 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 경주는 1라운드 이상, 100라운드 이하만 시작할 수 있다")
    @ValueSource(ints = {0, 101})
    @ParameterizedTest
    void 자동차_경주_시작_실패_총_라운드(int roundTotal) {
        assertThatThrownBy(() -> racingCarService.startRacing(nameValues, roundTotal))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
