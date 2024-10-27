package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ValidatorTest {

    Validator validator;
    RacingGame racingGame;
    String cars;
    String[] groupCars;

    @BeforeEach
    void setUp() {
        validator = new Validator(cars);
        racingGame = new RacingGame(groupCars,cars);
    }
    
    @Test
    @DisplayName("중복된 이름 테스트")
    void checkSameCarNamesTest() {
        String[] carNames = {"a","a"};
        assertThatThrownBy(() -> validator.checkSameCarNames(carNames)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백이 들어간 이름")
    void checkEmptyCarNamesTest() {
        String[] carNames = {"a ","aaa"};
        assertThatThrownBy(() -> validator.checkEmptyCarNames(carNames)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("양수가 아닌 입력 테스트")
    void checkTryNumberTest() {
        racingGame = new RacingGame(new String[]{"A","b"},"-5");
        assertThatThrownBy(racingGame::changeTryTimesNumber).isInstanceOf(IllegalArgumentException.class);
    }
}