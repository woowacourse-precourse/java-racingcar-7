package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class ExecutionResultTest {

    @Test
    void 이름과_이동거리를_문자열로_반환한다() {
        Car car = new Car("pobi");
        car.increasePosition();
        ExecutionResult result = ExecutionResult.ofValue(car);
        assertThat(result.toString()).isEqualTo("pobi : -");
    }
}