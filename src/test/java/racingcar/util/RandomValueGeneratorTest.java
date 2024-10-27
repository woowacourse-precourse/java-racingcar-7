package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RandomValueGeneratorTest {

    static final int DEFAULT_START_INCLUSIVE = 0;
    static final int DEFAULT_END_INCLUSIVE = 9;

    @Test
    @DisplayName("랜덤 값(0~9) 생성 로직에 예외가 발생하지 않는다.")
    void 랜덤값1개생성_0부터9사이() {
        // given
        RandomValueGenerator randomValueGenerator = new RandomValueGenerator();

        // when
        int randomValue = randomValueGenerator.generateSingle(DEFAULT_START_INCLUSIVE, DEFAULT_END_INCLUSIVE);

        // then
        assertTrue(randomValue >= DEFAULT_START_INCLUSIVE && randomValue <= DEFAULT_END_INCLUSIVE,
                "랜덤 값이 지정된 범위 내에 있어야 합니다.");
    }

    @Test
    @DisplayName("여러 개의 정상적인 랜덤 값(0~9) 생성 시, 모든 값이 지정된 범위 내에 있어야 한다.")
    void 랜덤값여러개생성_0부터9사이() {
        // given
        RandomValueGenerator randomValueGenerator = new RandomValueGenerator();
        int count = 10000;

        // when
        List<Integer> randomValues = randomValueGenerator.generateMultiple(DEFAULT_START_INCLUSIVE, DEFAULT_END_INCLUSIVE, count);

        // then
        assertEquals(count, randomValues.size(), "생성된 랜덤 값의 개수가 일치해야 합니다.");

        // 모든 값이 범위 내에 있는지 확인
        randomValues.forEach(value ->
                assertTrue(value >= DEFAULT_START_INCLUSIVE && value <= DEFAULT_END_INCLUSIVE,
                        "랜덤 값이 지정된 범위 내에 있어야 합니다.")
        );
    }

}
