package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("자동차 이름이 5자 초과인 경우 예외 발생")
    void 자동차_이름이_6자_이상이면_예외() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Car("길이가6글자"));
    }

    @Test
    @DisplayName("자동차 이름이 5자 이하이면 정상 생성")
    void 자동차_이름이_5자_이하이면_생성() {
        Car car = new Car("정상이름");
        Assertions.assertEquals("정상이름", car.getName());
    }

    @Test
    @DisplayName("moveForward 호출 시 moveCount 증가")
    void 자동차_직진인경우_moveCount_증가() {
        Car car = new Car("차이동");
        car.movement();
        Assertions.assertEquals(1, car.getMoveCount());
    }

}
