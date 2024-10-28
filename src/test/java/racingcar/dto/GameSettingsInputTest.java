package racingcar.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameSettingsInputTest {

    @Test
    void 유효한_입력으로_GameSettingsInput을_생성한다() {
        CarNamesInput carNamesInput = new CarNamesInput("pobi,woni,jun");
        TryCountInput tryCountInput = new TryCountInput("5");

        GameSettingsInput gameSettingsInput = GameSettingsInput.of(carNamesInput, tryCountInput);

        assertThat(gameSettingsInput.carNames()).containsExactly("pobi", "woni", "jun");
        assertThat(gameSettingsInput.tryCount()).isEqualTo(5);
    }
}
