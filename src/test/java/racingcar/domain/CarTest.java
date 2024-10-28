package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    private final Car testCar = new Car("자동차");
    private final Car testCar2 = new Car("해적선");

    private final int movable_num = Randoms.pickNumberInRange(4, 9);
    private final int unmovable_num = Randoms.pickNumberInRange(0, 3);

    @Test
    @DisplayName("전진 가능한 최솟값을 넘으면 자동차는 전진한다")
    void move_when_over_margin() {
        testCar.move(movable_num);

        Assertions.assertEquals(testCar.getDistance(), 1);
    }

    @Test
    @DisplayName("전진 가능한 최솟값보다 작으면 자동차는 전진하지 않는다")
    void stop_when_under_margin() {
        testCar.move(unmovable_num);

        Assertions.assertEquals(testCar.getDistance(), 0);
    }

    @Test
    @DisplayName("전진한 자동차와 멈춘 자동차의 거리를 정상적으로 비교한다")
    void compare_cars() {
        testCar.move(movable_num);
        testCar2.move(unmovable_num);

        Assertions.assertTrue(testCar.compareTo(testCar2) < 0);
    }

    @Test
    @DisplayName("검증되지 않은 이름으로 자동차를 생성하면 예외다")
    void throw_when_name_is_invalid() {
        String invalidName = "franki";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Car(invalidName);
        });
    }
}
