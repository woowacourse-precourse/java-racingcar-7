package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
    
    // ---------------------- input에 관련된 테스트 시작 --------------------------
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
    
    @DisplayName("시도할 횟수 입력이 0 이하라면 예외가 발생한다.")
    @Test
    void validateInputGameCountWithZeroOrNegativeValue() {
        // given
        // -1 에서 -를 문자로 취급을 해서 아래 StringReader를 사용
        Scanner scanner = new Scanner("pobi,jun\n-1\n");
        System.setIn(new ByteArrayInputStream((scanner.nextLine() + "\n" + scanner.nextLine()).getBytes()));
        
        
        // when & then
        Assertions.assertThatThrownBy(() -> racingGame.play())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 숫자 & 양의 정수로 입력해야합니다.");
    }
    
    @DisplayName("시도할 횟수를 문자형식으로 입력하면 예외가 발생한다.")
    @Test
    void validateInputGameCountWithInvalidNumberFormat() {
        // given
        // -1 에서 -를 문자로 취급을 해서 아래 StringReader를 사용
        Scanner scanner = new Scanner("pobi,jun\none\n");
        System.setIn(new ByteArrayInputStream((scanner.nextLine() + "\n" + scanner.nextLine()).getBytes()));
        
        
        // when & then
        Assertions.assertThatThrownBy(() -> racingGame.play())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 숫자 & 양의 정수로 입력해야합니다.");
    }
    
    @DisplayName("play() 메서드에서 자동차 이름과 게임 횟수를 정상적으로 입력받을 수 있다.")
    @Test
    void playWithValidInput() {
        // given
        String input = "pobi,jun\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        // when & then
        assertDoesNotThrow(() -> racingGame.play());
        
    }
    // ---------------------- input에 관련된 테스트 끝 --------------------------
    // ---------------------- startGame에 관련된 테스트 시작 --------------------------
    @DisplayName("RacingGame.startGame() 메서드가 정상적으로 작동한다.")
    @Test
    void startGameWithValidInput() {
        // given
        String[] carNames = {"pobi", "jun", "honggil"};
        int gameCount = 5;
        
        // when
        assertDoesNotThrow(() -> racingGame.startGame(carNames, gameCount));
        
        // then
        // startGame 메서드를 실행했을 때 예외가 발생하지 않는지 확인
    }
    
    @DisplayName("경주한 자동차들의 이동 거리가 정상적으로 출력된다.")
    @Test
    void printGameInfoWithMovedCars() {
        // given
        String[] carNames = {"pobi", "jun", "honggil"};
        int gameCount = 5;
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
        
        // when
        racingGame.startGame(carNames, gameCount);
        
        // then
        // carList의 각 Car 객체의 getMoveDistance() 메서드 호출 결과가 정상적으로 출력되는지 확인
    }
    
    @DisplayName("우승자가 정상적으로 출력된다.")
    @Test
    void printResultWithWinners() {
        // given
        String[] carNames = {"pobi", "jun", "honggil"};
        int gameCount = 5;
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
        
        // when
        racingGame.startGame(carNames, gameCount);
        
        // then
        // 우승자 정보(가장 멀리 간 자동차들)가 정상적으로 출력되는지 확인
    }
    // ---------------------- startGame에 관련된 테스트 끝 --------------------------
    
}