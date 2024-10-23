package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CarTest {

    @Test
    void 차량_이름_5자_이하_테스트() {
        try {
            Car car = new Car("porsche");
            fail("테스트에 실패하였습니다.");
        } catch (IllegalArgumentException e) {
            assertEquals("[ERROR] 자동차 이름은 5자 이하여야 합니다.", e.getMessage());
        }
    }
}
