package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarException;

@DisplayName("진행 횟수 파싱 테스트")
class RaceRoundParserTest {
    /**
     * 1. 정상적인 숫자 반환 테스트 2. 숫자가 아닌 값이 들어있을 경우 예외 발생 3. parseInt 시 예외
     */

    @Test
    public void 정상_숫자_입력시_반환_성공() {
        // given
        String rawRoundsToRace = "4921";

        // when
        int actual = RaceRoundParser.parseRaceRound(rawRoundsToRace);

        // then
        Assertions.assertThat(actual).isEqualTo(4921);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12.1", "-12", "5431.", "12+21", "+11"})
    public void 숫자가_아닌_문자_섞여있을시_예외_발생(String rawRoundsToRace) {
        // when, then
        Assertions.assertThatThrownBy(() -> RaceRoundParser.parseRaceRound(rawRoundsToRace))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"2147483648", "21474836489343214134"})
    public void 유효하지_않은_정수_입력시_예외_발생(String rawRoundsToRace) {
        // when, then
        Assertions.assertThatThrownBy(() -> RaceRoundParser.parseRaceRound(rawRoundsToRace))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(ErrorMessage.INVALID_INTEGER_FORMAT.getMessage());
    }
}