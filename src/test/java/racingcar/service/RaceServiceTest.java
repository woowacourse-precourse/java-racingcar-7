package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class RaceServiceTest {

    private RaceService raceService;

    @BeforeEach
    void setUp() {
        this.raceService = new RaceService();
    }

    @DisplayName("자동차 이름을 쉼표 기준으로 분리하는 기능 테스트")
    @Test
    public void splitCarNamesTest() {
        String[] carNames = raceService.splitCarNames("pobi,won,juni");
        assertEquals(carNames[0], "pobi");
        assertEquals(carNames[1], "won");
        assertEquals(carNames[2], "juni");
    }

    @DisplayName("자동차 이름이 유효하지 않을 경우 예외를 발생시키는지 테스트")
    @Test
    public void invalidCarNameTest() {
        String[] invalidCarNames = {"pobi12345", "karina"};
        for (String name : invalidCarNames) {
            org.junit.jupiter.api.Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> new Car(name),
                    "차 이름은 5자 이하여야 합니다."
            );
        }
    }
}
