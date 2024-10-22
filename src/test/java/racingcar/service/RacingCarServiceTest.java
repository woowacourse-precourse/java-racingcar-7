package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.constants.ErrorMessage.DUPLICATE_CAR_NAME;
import static racingcar.exception.constants.ErrorMessage.EMPTY_CAR_NAME_NOT_ALLOWED;
import static racingcar.exception.constants.ErrorMessage.INVALID_NUMBER;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.RacingCarRequestDto;
import racingcar.dto.RacingCarResponseDto;
import racingcar.exception.RacingCarException;

class RacingCarServiceTest {

    private final RacingCarService racingCarService = new RacingCarService();

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(strings = {"1", "1,2", "1,2,3", "1, 2, 3"})
    void 레이싱_경주_시작(final String input) {
        // given
        RacingCarRequestDto requestDto = new RacingCarRequestDto(input, 5);

        // when
        RacingCarResponseDto responseDto = racingCarService.start(requestDto);

        // then
        String winnerName = responseDto.winnerName();

        assertThat(winnerName).isNotNull();
        System.out.println(winnerName);
    }

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(strings = {"", "1,", "1,,3", "1, ,3", " ,2,3"})
    void 예외_빈_값_입력(final String input) {
        // given
        RacingCarRequestDto requestDto = new RacingCarRequestDto(input, 5);

        // when & then
        assertThatThrownBy(() -> racingCarService.start(requestDto))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(EMPTY_CAR_NAME_NOT_ALLOWED.getMessage());
    }

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(strings = {"1,1", "1,2,2", "1,2,1"})
    void 예외_중복된_값_입력(final String input) {
        // given
        RacingCarRequestDto requestDto = new RacingCarRequestDto(input, 5);

        // when & then
        assertThatThrownBy(() -> racingCarService.start(requestDto))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(DUPLICATE_CAR_NAME.getMessage());
    }

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(ints = {-1, 0})
    void 예외_음수_또는_0인_라운드_값_입력(final int input) {
        // given
        RacingCarRequestDto requestDto = new RacingCarRequestDto("1,2,3", input);

        // when & then
        assertThatThrownBy(() -> racingCarService.start(requestDto))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(INVALID_NUMBER.getMessage());
    }
}