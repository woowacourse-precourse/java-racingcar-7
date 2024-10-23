package racingcar.creator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

class RacingCarGameCreatorTest {

    @DisplayName("[정상] RacingCar 리스트 변환")
    @Test
    void parsing() {
        // given
        RacingCarGameCreator creator = new RacingCarGameCreator("a,b,c", 5);
        // when
        List<RacingCar> carList = creator.getCarList();
        // then
        assertEquals("a", carList.get(0).getId());
        assertEquals("b", carList.get(1).getId());
        assertEquals("c", carList.get(2).getId());
        assertEquals(5, creator.getTotalRound());
    }
}