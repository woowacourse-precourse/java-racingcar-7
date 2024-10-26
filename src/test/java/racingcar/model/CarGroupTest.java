package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarGroupTest {

    @Test
    void 자동차_수_테스트() {
        // given
        String carNames = "ghim,yu,gyeom";
        CarGroup carGroup = new CarGroup(carNames);

        // when & then
        assertEquals(3, carGroup.getCars().size());
    }

    @Test
    void 자동차_수가_2보다_작을_경우_예외_발생() {
        // given
        String carNames = "gyeom";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new CarGroup(carNames));
    }
}
