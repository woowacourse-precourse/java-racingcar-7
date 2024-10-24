package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameNumberTest {

    @Test
    @DisplayName("게임 횟수 변환을 테스트한다.")
    void findGameNumber() {
        //given
        String gameNumber = "5";

        //when
        int value = GameNumber.findGameNumber(gameNumber);

        //then
        assertThat(value).isEqualTo(5);
    }

    @Test
    @DisplayName("게임 횟수 입력이 없을 때 예외를 테스트한다.")
    void EmptyGameNumberException() {
        //given
        String gameNumber = "";

        assertThatThrownBy(() -> GameNumber.findGameNumber(gameNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 횟수가 숫자가 아닐 때 예외를 테스트한다.")
    void NotIntegerGameNumberException() {
        //given
        String gameNumber = "i";

        assertThatThrownBy(() -> GameNumber.findGameNumber(gameNumber)).isInstanceOf(IllegalArgumentException.class);
    }
}