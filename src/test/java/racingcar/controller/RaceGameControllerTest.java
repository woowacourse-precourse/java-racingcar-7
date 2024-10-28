package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RaceGameControllerTest {

    private RaceGameController raceGameController;

    @BeforeEach
    void setUp() {
        raceGameController = new RaceGameController();
    }

    @DisplayName("라운드 수가 1 이상일 때만 진행 가능")
    @Test
    void 라운드_입력_검증() {
        int validRoundCount = 3;
        assertThatNoException().isThrownBy(() ->
                raceGameController.validateRoundCount(validRoundCount)
        );

        int invalidRoundCount = 0;
        assertThatThrownBy(() ->
                        raceGameController.validateRoundCount(invalidRoundCount)
                ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 이상의 값을 입력헤주세요");
    }

    @DisplayName("자동차 이름이 5자를 초과할 경우 예외 발생")
    @Test
    void 자동차이름_길이_검증() {
        String[] validNames = {"pobi", "woni"};
        assertThatNoException().isThrownBy(() ->
                raceGameController.validateCarNames(validNames)
        );

        String[] invalidNames = {"pobi와woni"};
        assertThatThrownBy(() ->
                        raceGameController.validateCarNames(invalidNames)
                ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 5자 이하만 가능합니다");
    }
}