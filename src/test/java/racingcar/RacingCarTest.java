package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @Test
    void 자동차_이름들이_쉼표로_구분되는지_확인() {
        RacingCar racingCar = new RacingCar();
        String[] test = racingCar.separateCarNames("pobi,woni,jun");
        Assertions.assertArrayEquals(new String[]{"pobi", "woni", "jun"}, test);
    }

    @Test
    void 구분자가_없는_경우_예외처리() {
        RacingCar racingCar = new RacingCar();
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                racingCar.separateCarNames("pobiwonijun"));
    }
}
