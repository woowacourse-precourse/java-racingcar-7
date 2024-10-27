package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingCarTest {

    private RacingCar car;

    @BeforeEach
    void setUp() {
        car = new RacingCar("pobi");
    }

    @Test
    @DisplayName("자동차 객체가 이름을 제대로 설정하는지 확인한다.")
    void testCarName() {
        assertEquals("pobi", car.getName());
    }

    @Test
    @DisplayName("랜덤 숫자가 4 이상일 때만 움직이는지 테스트한다.")
    void testCarMoveCondition() {
        // 랜덤 값이 5를 반환하도록 하는 테스트용 클래스
        RacingCar testCar = new TestableRacingCar("test", 5);
        int initialMoveCount = testCar.getMoveCount();

        testCar.move();

        assertEquals(initialMoveCount + 1, testCar.getMoveCount());
    }

    @Test
    @DisplayName("랜덤 숫자가 4 미만일 때는 움직이지 않는지 테스트한다.")
    void testCarNoMoveCondition() {
        // 랜덤 값이 3을 반환하도록 하는 테스트용 클래스
        RacingCar testCar = new TestableRacingCar("test", 3);
        int initialMoveCount = testCar.getMoveCount();

        testCar.move();

        assertEquals(initialMoveCount, testCar.getMoveCount()); // 움직이지 않음
    }

    // 테스트용으로 랜덤 숫자를 고정시키는 클래스
    private static class TestableRacingCar extends RacingCar {
        private final int fixedRandomValue;

        public TestableRacingCar(String carName, int fixedRandomValue) {
            super(carName);
            this.fixedRandomValue = fixedRandomValue;
        }

        @Override
        protected int getRandomInteger() {
            return fixedRandomValue;
        }
    }
}
