package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarGroupTest {

    @Test
    void 자동차_수_테스트() {
        // given
        List<String> carNames = Arrays.stream("ghim,yu,gyeom".split(",")).toList();
        CarGroup carGroup = new CarGroup(carNames);

        // when & then
        assertEquals(3, carGroup.getCars().size());
    }

    @Test
    void 자동차_수가_2보다_작을_경우_예외_발생() {
        // given
        List<String> carNames = Arrays.stream("gyeom".split(",")).toList();

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new CarGroup(carNames));
    }
}
