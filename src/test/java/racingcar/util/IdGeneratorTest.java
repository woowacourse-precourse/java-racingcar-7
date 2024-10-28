package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IdGeneratorTest {

    @DisplayName("ID 생성 시 1부터 순차적으로 증가하는 값을 반환한다")
    @Test
    void generate() {
        // given
        IdGenerator idGenerator = new IdGenerator();
        Long expectedSecondId = 2L;

        // when
        idGenerator.generate();
        Long actualId = idGenerator.generate();

        // then
        Assertions.assertThat(actualId).isEqualTo(expectedSecondId);
    }

}