package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    
    private RacingGame racingGame;
    
    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
    }
    
    // 기본적으로 테스트는 성공할시 별도의 메세지가 없고 초록색으로 통과 표시!!
    @DisplayName("입력된 문자열이 null이거나 빈 문자열인 경우 예외가 발생한다.")
    @Test
    void validateInputCarNameIsNullOrEmpty() {
        // given
        // 빈값을 주기 위한 코드
        System.setIn(new ByteArrayInputStream("\n".getBytes()));
        // when & then
        Assertions.assertThatThrownBy(() -> racingGame.play())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력받는 값이 공백일 수 없습니다.");
    }
    
    @DisplayName("입력된 문자열이 5자 초과의 이름일 경우 예외가 발생한다.")
    @Test
    void validateInputCarNameGreaterThen5() {
        // given
        System.setIn(new ByteArrayInputStream("pobi,jungkook,hoseok,honggil,jaeho\n".getBytes()));
        // when & then
        Assertions.assertThatThrownBy(() -> racingGame.play())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("5자 이하의 이름만 입력할 수 있습니다. : jungkook");
    }
    
    @DisplayName("입력된 문자열에서 split으로 배열을 추출할 때 빈값이 있다면 예외가 발생한다.")
    @Test
    void validateInputCarNamesSplit() {
        // given
        System.setIn(new ByteArrayInputStream("pobi,,jungkook,hoseok,honggil\n".getBytes()));
        // when & then
        Assertions.assertThatThrownBy(() -> racingGame.play())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백일 수 없습니다.");
    }
    
    @DisplayName("정상적인 입력의 경우 예외가 발생하지 않는다.")
    @Test
    void validateValidInput() {
        // given
        System.setIn(new ByteArrayInputStream("pobi,jun\n".getBytes()));
        // when & then
        assertDoesNotThrow(() -> racingGame.play());
    }
}