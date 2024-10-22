package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Assertions.assertThrows(IllegalArgumentException.class, () -> racingCar.separateCarNames("pobiwonijun"));
    }

    @Test
    void 자동차_이름이_5자를_초과할경우_예외처리() {
        RacingCar racingCar = new RacingCar();
        Assertions.assertThrows(IllegalArgumentException.class, () -> racingCar.separateCarNames("pobipobi,woni,jun"));
    }

    @Test
    void 시도할_횟수가_양수가_아닌_경우_예외처리() {
        RacingCar racingCar = new RacingCar();
        Assertions.assertThrows(IllegalArgumentException.class, () -> racingCar.validateNumberOfAttempts("-1"));
    }

    @Test
    void 숫자_조건을_만족할경우_전진하는지_테스트() {
        RacingCar racingCar = new RacingCar() {
            @Override
            protected int generateRandomNumber() {
                return 5;
            }
        };

        racingCar.separateCarNames("pobi,woni,jun");
        racingCar.race(1);
        int[] carCount = racingCar.getCarCount();

        for (int Count : carCount) {
            assertEquals(1, Count);
        }
    }

    @Test
    void 숫자_조건을_불만족할경우_그대로_있는지_테스트() {
        RacingCar racingCar = new RacingCar() {
            @Override
            protected int generateRandomNumber() {
                return 3;
            }
        };

        racingCar.separateCarNames("pobi,woni,jun");
        racingCar.race(1);
        int[] carCount = racingCar.getCarCount();

        for (int Count : carCount) {
            assertEquals(0, Count);
        }
    }
}
