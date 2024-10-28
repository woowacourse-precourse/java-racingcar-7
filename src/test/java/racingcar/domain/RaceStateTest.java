package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class RaceStateTest {

    private RaceState raceState;

    @BeforeEach
    void setUp() {
        raceState = new RaceState();
    }

    @Test
    @DisplayName("게임 초기화 시 자동차 리스트가 생성")
    void 게임_초기화_시_리스트_생성() {
        // given
        List<String> cars = List.of("kim", "glenn");

        // when
        raceState.initGame(cars);

        // then
        assertEquals(2, raceState.getCars().size());
        assertEquals("kim", raceState.getCars().get(0).getName());
        assertEquals("glenn", raceState.getCars().get(1).getName());
    }

    @Test
    @DisplayName("랜덤 숫자에 따라 자동차 전진")
    void 자동차_전진_확인() {
        // given
        List<String> cars = List.of("kim");
        raceState.initGame(cars);

        // when
        boolean anyCarMoved = false;
        for (int i = 0; i < 100; i++) {
            raceState.playRound();
            if (raceState.getCars().getFirst().getPosition() > 0) {
                anyCarMoved = true;
                break;
            }
        }

        // then
        assertTrue(anyCarMoved); // 100번 중 한 번은 전진
    }

}