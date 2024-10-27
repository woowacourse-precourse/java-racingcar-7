package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class ExecutionResultTest {

    @Test
    void testToString() {
        Car car = new Car("pobi");
        car.increasePosition();
        ExecutionResult result = ExecutionResult.ofValue(car);
        assertThat(result.toString()).isEqualTo("pobi : -");
    }
}