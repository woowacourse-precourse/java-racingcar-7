package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

class CarTest extends NsTest {

    @Test
    void 자동차_이름과_초기_위치_테스트() {
        Car car = new Car("pobi");
        assert(car.getName().equals("pobi"));
        assert(car.getPosition() == 0);
    }

    @Test
    void 전진_성공_테스트() {
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(
            () -> {
                car.move(4);
                assert(car.getPosition() == 1);
            },
            4 
        );
    }

    @Test
    void 전진_실패_테스트() {
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(
            () -> {
                car.move(3);
                assert(car.getPosition() == 0);
            },
            3
        );
    }

    @Test
    void 위치_출력_테스트() {
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(
            () -> {
                car.move(4);
                car.move(4);
                assert(car.displayPosition().equals("pobi : --"));
            },
            4, 4
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
