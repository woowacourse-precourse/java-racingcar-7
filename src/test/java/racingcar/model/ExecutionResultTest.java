package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class ExecutionResultTest {

    @Test
    void testToString() {
        ExecutionResult result = new ExecutionResult("pobi", 3);
        assertThat(result.toString()).isEqualTo("pobi : ---");
    }
}