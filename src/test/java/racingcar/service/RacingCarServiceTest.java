package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.dto.RacingCarRequestDto;
import racingcar.dto.RacingCarResponseDto;

class RacingCarServiceTest {

    private final RacingCarService racingCarService = new RacingCarService();

    @Test
    void 레이싱_경주_시작() {
        // given
        RacingCarRequestDto requestDto = new RacingCarRequestDto("1,2,3", 5);

        // when
        RacingCarResponseDto responseDto = racingCarService.start(requestDto);

        // then
        String winnerName = responseDto.winnerName();

        assertThat(winnerName).isNotNull();
        System.out.println(winnerName);
    }
}