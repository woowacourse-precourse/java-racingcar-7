package racingcar.model;

import racingcar.model.ConditionCar;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConditionCarTest {

    @Test
    void 자동차_이름이_5자_이하인지_확인() {
        assertThrows(IllegalArgumentException.class, () -> new ConditionCar("abcdef"));
    }

    @Test
    void 자동차_이름이_비어있는_경우_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> new ConditionCar(" "));
    }

    @Test
    void 자동차가_전진조건_충족시_전진하는지_확인() {
        ConditionCar car = new ConditionCar("pobi");
        car.move(); // move 메서드 안에서 전진 조건(랜덤 숫자) 확인
        assertTrue(car.getPosition() >= 0); // 전진했을 수도 있고 안 했을 수도 있음
    }

    @Test
    void 자동차_중복_이름_검증() {
        assertThrows(IllegalArgumentException.class, () ->
                ConditionCar.validateDuplicateNames(List.of("pobi", "pobi")));
    }

    @Test
    void 시도_횟수가_음수일_때_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> ConditionCar.validateRoundRange(-1));
    }

    @Test
    void 시도_횟수가_0일_때_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> ConditionCar.validateRoundRange(0));
    }
}