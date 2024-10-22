package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.constants.ErrorMessage.EMPTY_CAR_NAME_NOT_ALLOWED;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.RacingCarRequestDto;
import racingcar.dto.RacingCarResponseDto;
import racingcar.exception.RacingCarException;

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

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(strings = {"", "1,", "1,,3", "1, ,3"})
    void 예외_빈_값_입력(String input) {
        // given
        RacingCarRequestDto requestDto = new RacingCarRequestDto(input, 5);

        // when & then
        assertThatThrownBy(() -> racingCarService.start(requestDto))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(EMPTY_CAR_NAME_NOT_ALLOWED.getMessage());
    }
}