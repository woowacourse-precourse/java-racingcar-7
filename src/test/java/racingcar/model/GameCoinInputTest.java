package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameCoinInputTest {
    @Test
    @DisplayName("정상적인 수 입력의 경우 테스트")
    void getGameCoinTest() {
        //given
        String userInput = "5";
        //when
        GameCoinInput gameCoinInput = new GameCoinInput(userInput);
        //then
        assertThat(gameCoinInput.getGameCoin())
                .isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", " ", "3a", ".", "3 3"})
    @DisplayName("숫자가 아닌 형식의 입력의 경우 테스트")
    void validateNumberTest(String userInput) {
        assertThatThrownBy(() -> {
            new GameCoinInput(userInput);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력해 주세요");

    }

    @Test
    @DisplayName("게임 할 수 있는 횟수를 벗어난 입력의 경우 테스트")
    void validateOverFlowTest() {
        //givne
        String userInput = "2147483648";
        //when & then
        assertThatThrownBy(() -> {
            new GameCoinInput(userInput);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 할 수 있는 수의 최대치를 넘었습니다");
        ;
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    @DisplayName("0 이하의 숫자 입력의 경우 테스트")
    void validateNumberMinimum(String userInput) {
        assertThatThrownBy(() -> {
            new GameCoinInput(userInput);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 보다 큰 수를 입력해 주세요");

    }
}
