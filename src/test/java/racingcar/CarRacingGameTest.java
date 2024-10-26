package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class CarRacingGameTest {
    private CarRacingGame game;

    @BeforeEach
    public void before() {
        game = new CarRacingGame();
    }

    @ParameterizedTest
    @MethodSource("vaildInput")
    @DisplayName("구분자를 기준으로한 자동차 이름 입력 테스트 ")
    public void createCarsFromNames(String carNames) {
        game.createCarsFromNames(carNames);
    }
}